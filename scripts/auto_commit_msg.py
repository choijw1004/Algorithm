import sys
import os
import subprocess
import requests
import re
from pathlib import Path

PROBLEMS_DIR = './src/ver2'
SPRING_API_URL = 'http://localhost:8080/api/problem/analyze'

def get_staged_java_files():
    result = subprocess.run(
        ['git', 'diff', '--cached', '--diff-filter=AMCR', '--name-only'],
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

    all_comments = re.findall(r'/\*([\s\S]*?)\*/', content)

    for comment_content in reversed(all_comments):
        link_match = re.search(r'# 문제 링크\s*\n\s*([^\n]+)', comment_content)

        if link_match:
            problem_link = link_match.group(1).strip()

            # 카테고리
            category_match = re.search(r'# 카테고리\s*\n([^\n#]+)', comment_content)
            categories = []
            if category_match:
                categories = [c.strip() for c in category_match.group(1).split(',') if c.strip()]

            # 접근 방식
            approach_match = re.search(r'# 접근 방식\s*\n([\s\S]*?)(?=\n# |$)', comment_content)
            approach = approach_match.group(1).strip() if approach_match else ''

            return {
                'problem_link': problem_link,
                'categories': categories,
                'approach': approach
            }

    return {
        'problem_link': None,
        'categories': [],
        'approach': ''
    }
def call_spring_api(problem_link, categories, approach):
    """Spring API 호출"""
    try:
        response = requests.post(SPRING_API_URL, json={
            'problemLink': problem_link,
            'problemCategories': categories,
            'problemApproach': approach
        }, timeout=30)

        if response.status_code == 200:
            return response.json()
        else:
            print(f"API 호출 실패: {response.status_code}")
            print(f"응답: {response.text}")
            return None
    except requests.exceptions.RequestException as e:
        print(f"API 호출 에러: {e}")
        return None

def remove_metadata_comments(content):
    """메타데이터 주석 제거 (# 로 시작하는 줄)"""
    lines = content.split('\n')
    filtered_lines = [line for line in lines if not line.strip().startswith('#')]
    return '\n'.join(filtered_lines)

def create_problem_directory(result, java_file, content):
    """디렉토리 생성 및 파일 이동"""
    dir_name = result['directoryName']
    problem_dir = Path(PROBLEMS_DIR) / dir_name
    problem_dir.mkdir(parents=True, exist_ok=True)

    # package 수정
    dir_name_safe = dir_name.replace('-', '_')
    modified_content = re.sub(
        r'package\s+ver2\s*;',
        f'package ver2.{dir_name_safe};',
        content
    )

    # package 없으면 추가
    if 'package' not in modified_content:
        modified_content = f'package ver2.{dir_name_safe};\n\n' + modified_content

    # ❌ 메타데이터 주석 제거 - 이 줄 삭제!
    # clean_content = remove_metadata_comments(modified_content)

    # ✅ 주석 그대로 유지
    clean_content = modified_content

    # Java 파일 저장
    java_filename = Path(java_file).name
    new_java_path = problem_dir / java_filename
    with open(new_java_path, 'w', encoding='utf-8') as f:
        f.write(clean_content)

    # 원본 파일 삭제
    if Path(java_file).resolve() != new_java_path.resolve():
        os.remove(java_file)

    # README 저장 (Spring에서 받은 내용 + 코드 추가)
    readme_content = result['readmeContent']

    # 코드 부분 추가 (주석 포함)
    code_for_readme = clean_content
    readme_content += f"\n## 코드\n```java\n{code_for_readme}\n```\n"

    with open(problem_dir / 'README.md', 'w', encoding='utf-8') as f:
        f.write(readme_content)

    print(f"디렉토리 생성: {dir_name}")
    print(f"README 생성: {problem_dir / 'README.md'}")

    subprocess.run(['git', 'add', str(problem_dir)], check=False)
    print(f"✅ Git staged: {problem_dir}")

def main():
    # pre-commit 모드: 파일 생성 + 커밋 메시지를 임시 파일에 저장
    is_pre_commit = '--pre-commit' in sys.argv

    # Java 파일 확인
    java_files = get_staged_java_files()
    if not java_files:
        sys.exit(0)

    java_file = java_files[0]

    # 파일 읽기
    content = read_file(java_file)
    if not content:
        print("파일 읽기 실패")
        sys.exit(1)

    # 메타데이터 추출
    metadata = extract_metadata(content)

    if not metadata['problem_link']:
        commit_msg = "feat: 알고리즘_문제해결"
        print("문제 링크 없음 - 기본 커밋 메시지 사용")
    else:
        print(f"문제 분석 중: {metadata['problem_link']}")

        # Spring API 호출
        result = call_spring_api(
            metadata['problem_link'],
            metadata['categories'],
            metadata['approach']
        )

        if not result:
            commit_msg = "feat: 알고리즘_문제해결"
            print("API 호출 실패 - 기본 커밋 메시지 사용")
        else:
            commit_msg = result['commitMessage']
            print(f"플랫폼: {result['platform']}")
            print(f"디렉토리명: {result['directoryName']}")
            print(f"커밋 메시지: {commit_msg}")

            # 디렉토리 생성 및 파일 저장
            create_problem_directory(result, java_file, content)

    # 커밋 메시지 저장
    # pre-commit 모드: 임시 파일에 저장 (prepare-commit-msg에서 읽음)
    # 기존 모드: 커밋 메시지 파일에 직접 저장
    if is_pre_commit:
        with open('/tmp/algo_commit_msg.txt', 'w', encoding='utf-8') as f:
            f.write(commit_msg)
    else:
        commit_msg_file = sys.argv[1]
        with open(commit_msg_file, 'w', encoding='utf-8') as f:
            f.write(commit_msg)

    print(f"커밋 메시지: {commit_msg}")

if __name__ == '__main__':
    main()