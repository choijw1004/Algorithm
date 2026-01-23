import sys
import os
import subprocess
import ollama
import re
from pathlib import Path

PROBLEMS_DIR = './src/ver2'

def get_staged_java_files():
    result = subprocess.run(
        ['git', 'diff', '--cached', '--name-only'],
        capture_output=True,
        text=True
    )
    files = result.stdout.strip().split('\n')
    return [f for f in files if f.endswith('.java') and 'src/ver2' in f]

def read_file(file_path):
    """파일 읽기"""
    try:
        with open(file_path, 'r', encoding='utf-8') as f:
            return f.read()
    except:
        return None

def extract_metadata(content):
    # 문제 링크
    link_match = re.search(r'# 문제 링크\s*\n\s*([^\n]+)', content)
    problem_link = link_match.group(1).strip() if link_match else None

    # 카테고리
    category_match = re.search(r'# 카테고리\s*\n([^\n#]+)', content)
    categories = []
    if category_match:
        categories = [c.strip() for c in category_match.group(1).split(',') if c.strip()]

    # 접근 방식
    approach_match = re.search(r'# 접근 방식\s*\n([\s\S]*?)(?=\n# |$)', content)
    approach = approach_match.group(1).strip() if approach_match else ''

    return {
        'problem_link': problem_link,
        'categories': categories,
        'approach': approach
    }

def analyze_with_ollama(problem_link):

    prompt = f"""전달해준 문제 링크를 분석해서 다음 정보를 추출해줘.

문제 링크: {problem_link}

추출할 정보:
1. 플랫폼 (백준/리트코드/프로그래머스)
2. 문제 번호 (플랫폼이 프로그래머스면 문제번호는 생략)
3. 문제 이름

응답 형식 (반드시 이 형식으로):
플랫폼|문제번호|문제이름

문제 이름 처리 규칙:
1. 한글 문제: 띄어쓰기만 제거, 나머지는 원본 그대로
   - "DFS와 BFS" → "DFS와BFS"
   - "이진 검색 트리" → "이진검색트리"
2. 영문 문제: 각 단어 첫글자 대문자, 띄어쓰기는 언더바(_)
   - "k radius subarray averages" → "K_Radius_Subarray_Averages"
   - "two sum" → "Two_Sum"
3. 특수문자는 제거하지 말고 그대로 유지

플랫폼별 예시:
- 백준: BOJ|1260|DFS와BFS
- 백준: BOJ|2580|스도쿠
- 리트코드: Leet|2090|K_Radius_Subarray_Averages
- 리트코드: Leet|1|Two_Sum
- 프로그래머스: PGMS||네트워크 (문제 번호 없으면 비워두기)
- 프로그래머스: PGMS||타겟넘버

규칙:
- 반드시 "플랫폼|문제번호|문제이름" 형식으로만 답해줘
- 다른 설명이나 부연 설명 절대 추가하지 마
- 띄어쓰기는 언더바(_)
- 한 줄로만 답해줘"""

    try:

        response = ollama.chat(
            model='qwen3:8b',
            messages=[{'role': 'user', 'content': prompt}],
            options={'temperature': 0.2}
        )

        result = response['message']['content'].strip().split('\n')[0]

        # 파싱
        parts = result.split('|')
        if len(parts) >= 3:
            platform = parts[0].strip()
            number = parts[1].strip() if parts[1].strip() else None
            title = parts[2].strip()
            return platform, number, title

        return None, None, None

    except Exception as e:
        print(f"Ollama 에러: {e}")
        return None, None, None

def generate_directory_name(platform, number, title):
    if platform == "PGMS":
        return f"{platform}_{title}"
    elif number:
        return f"{platform}_{number}_{title}"
    else:
        return f"{platform}_{title}"

def generate_commit_message(platform, number, title):
    if platform == "PGMS":
        return f"feat: {platform}_{title}"
    elif number:
        return f"feat: {platform}_{number}_{title}"
    else:
        return f"feat: {platform}_{title}"

def create_problem_directory(dir_name, java_file, content, metadata):

    # 디렉토리 생성
    problem_dir = Path(PROBLEMS_DIR) / dir_name
    problem_dir.mkdir(parents=True, exist_ok=True)

    dir_name_safe = dir_name.replace('-', '_')
    modified_content = re.sub(
        r'package\s+ver2\s*;',
        f'package ver2.{dir_name_safe};',
        content
    )


    if 'package' not in modified_content:
        modified_content = f'package {dir_name};\n\n' + modified_content


    # Java 파일 이동 및 저장
    java_filename = Path(java_file).name
    new_java_path = problem_dir / java_filename

    with open(new_java_path, 'w', encoding='utf-8') as f:
        f.write(modified_content)

    # 원본 파일 삭제
    if Path(java_file).resolve() != new_java_path.resolve():
        os.remove(java_file)

    # README 생성
    create_readme(problem_dir, dir_name, modified_content, metadata)

def create_readme(problem_dir, problem_name, java_content, metadata):
    """개별 문제 README 생성"""

    code = re.sub(r'/\*[\s\S]*?\*/', '', java_content).strip()

    categories_str = ' '.join([f'`{c}`' for c in metadata['categories']])

    readme_content = f"""# {problem_name}

## 문제 링크
{metadata['problem_link']}

## 카테고리
{categories_str}

## 접근 방식
{metadata['approach']}

## 코드
```java
{code}
```
"""

    with open(problem_dir / 'README.md', 'w', encoding='utf-8') as f:
        f.write(readme_content)

    print(f"README 생성: {problem_dir / 'README.md'}")

def main():
    if len(sys.argv) < 2:
        sys.exit(1)

    commit_msg_file = sys.argv[1]

    # Java 파일 확인
    java_files = get_staged_java_files()
    if not java_files:
        sys.exit(0)

    java_file = java_files[0]

    # 파일 읽기
    content = read_file(java_file)
    if not content:
        sys.exit(1)

    # 메타데이터 추출
    metadata = extract_metadata(content)

    if not metadata['problem_link']:
        commit_msg = "feat: 알고리즘_문제해결"
    else:
        print("ollama 시작")
        platform, number, title = analyze_with_ollama(metadata['problem_link'])

        if not platform or not title:
            commit_msg = "feat: 알고리즘_문제해결"
        else:
            dir_name = generate_directory_name(platform, number, title)
            print(f"디렉토리명: {dir_name}")

            commit_msg = generate_commit_message(platform, number, title)
            print(f"커밋 메시지: {commit_msg}")

            create_problem_directory(dir_name, java_file, content, metadata)

    with open(commit_msg_file, 'w', encoding='utf-8') as f:
        f.write(commit_msg)

if __name__ == '__main__':
    main()