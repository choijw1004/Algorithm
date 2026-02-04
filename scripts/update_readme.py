import os
import re
from pathlib import Path

PROBLEMS_DIR = './src/ver2'
README_PATH = './README.md'


def parse_problem_readme(readme_path):
    """README.md에서 카테고리 추출"""
    try:
        with open(readme_path, 'r', encoding='utf-8') as f:
            content = f.read()

        # 디버깅 출력
        print(f"📄 파일: {readme_path}")

        category_match = re.search(r'## 카테고리\s*\n([^\n#]+)', content)
        if category_match:
            categories_str = category_match.group(1)
            print(f"  카테고리 문자열: {repr(categories_str)}")

            categories = re.findall(r'`([^`]+)`', categories_str)
            print(f"  추출된 카테고리: {categories}")

            return categories if categories else ['기타']
        else:
            print(f"  ⚠️ 카테고리 섹션 못 찾음!")

        return ['기타']
    except Exception as e:
        print(f"  ❌ 에러: {e}")
        return ['기타']


def generate_main_readme(problems_by_category):
    # 고정 헤더
    content = """# Algorithm, PS Repository

- [Github Actions 적용 전 repository ver 1](https://github.com/choijw1004/Algorithm/tree/main/src/ver1)
- [Github Actions 적용 후 repository ver 2 (현재)](https://github.com/choijw1004/Algorithm/tree/main/src/ver2)
---

## Algorithm 분류

"""

    print("\n📊 카테고리별 문제 수:")
    for category in sorted(problems_by_category.keys()):
        print(f"  {category}: {len(problems_by_category[category])}개")
        content += f"## {category}\n"

        for problem in problems_by_category[category]:
            content += f"- [{problem['name']}]({problem['path']})\n"

        content += "\n"

    return content


def main():
    problems_by_category = {}

    if not os.path.exists(PROBLEMS_DIR):
        print(f"❌ 디렉토리 없음: {PROBLEMS_DIR}")
        os.makedirs(PROBLEMS_DIR)
        return

    print(f"🔍 디렉토리 스캔: {PROBLEMS_DIR}\n")

    for problem_name in os.listdir(PROBLEMS_DIR):
        problem_path = Path(PROBLEMS_DIR) / problem_name

        if not problem_path.is_dir():
            continue

        readme_file = problem_path / 'README.md'
        if not readme_file.exists():
            print(f"⚠️ README 없음: {problem_name}")
            continue

        categories = parse_problem_readme(readme_file)

        readme_path = f"./src/ver2/{problem_name}/README.md"
        for category in categories:
            if category not in problems_by_category:
                problems_by_category[category] = []
            problems_by_category[category].append({
                'name': problem_name,
                'path': readme_path
            })

    # 메인 README 생성
    main_readme = generate_main_readme(problems_by_category)

    print(f"\n✅ 메인 README 생성: {README_PATH}")
    with open(README_PATH, 'w', encoding='utf-8') as f:
        f.write(main_readme)


if __name__ == '__main__':
    main()