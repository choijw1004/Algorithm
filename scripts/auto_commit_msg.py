#!/usr/bin/env python3
import sys
import subprocess
import ollama
import re

def get_staged_java_files():
    """스테이징된 src/ver2 Java 파일"""
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

def extract_problem_link(content):
    """주석에서 문제 링크 추출"""
    match = re.search(r'# 문제 링크\s*\n\s*([^\n]+)', content)
    return match.group(1).strip() if match else None

def generate_commit_message(problem_link):
    """Ollama로 커밋 메시지 생성"""

    prompt = f"""전달해준 문제 링크를 바탕으로 문제 번호, 문제 이름을 추출해서 커밋 메시지를 작성해줘.

문제 링크: {problem_link}

플랫폼별 형식:
- 리트코드: docs: Leet_문제번호_문제이름
- 백준: docs: BOJ_문제번호_문제이름
- 프로그래머스: docs: PGMS_문제이름 (문제 번호 없음)

규칙:
1. 문제 이름의 띄어쓰기는 언더바(_)로 변경
2. 반드시 "docs: "로 시작 (콜론 뒤에 공백 있음)
3. 문제 이름은 원본 그대로 유지 (예: "DFS와 BFS" → "DFS와BFS", 띄어쓰기만 제거)
4. 한 줄로만 작성

예시:
docs: Leet_2090_K_Radius_Subarray_Averages
docs: BOJ_1260_DFS와BFS
docs: PGMS_네트워크

커밋 메시지만 출력하고 다른 설명은 하지 마."""

    try:
        print("Ollama가 커밋 메시지 생성 중")

        response = ollama.chat(
            model='qwen3:8b',
            messages=[{'role': 'user', 'content': prompt}],
            options={'temperature': 0.2}
        )

        commit_msg = response['message']['content'].strip()

        commit_msg = commit_msg.split('\n')[0].strip()

        if not commit_msg.startswith('docs:'):
            commit_msg = 'docs: ' + commit_msg

        return commit_msg

    except Exception as e:
        return "docs: 알고리즘_문제해결"

def main():
    if len(sys.argv) < 2:
        sys.exit(1)

    commit_msg_file = sys.argv[1]

    # Java 파일 확인
    java_files = get_staged_java_files()
    if not java_files:
        sys.exit(0)


    # 파일 읽기
    content = read_file(java_files[0])
    if not content:
        sys.exit(1)

    # 문제 링크 추출
    problem_link = extract_problem_link(content)
    if not problem_link:
        commit_msg = "docs: 알고리즘_문제해결"
    else:
        # 커밋 메시지 생성
        commit_msg = generate_commit_message(problem_link)

    # 파일에 작성
    with open(commit_msg_file, 'w', encoding='utf-8') as f:
        f.write(commit_msg)

    print(f"커밋 메시지: {commit_msg}")

if __name__ == '__main__':
    main()