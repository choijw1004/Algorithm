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

        category_match = re.search(r'## 카테고리\s*\n([^\n#]+)', content)
        if category_match:
            categories_str = category_match.group(1)
            categories = re.findall(r'`([^`]+)`', categories_str)
            return categories if categories else ['기타']

        return ['기타']
    except:
        return ['기타']



def generate_main_readme(problems_by_category):
    # 고정 헤더
    content = """# Algorithm, PS Repository

- [Github Actions 적용 전 repository ver 1](https://github.com/choijw1004/Algorithm/tree/main/src/ver1)
- [Github Actions 적용 후 repository ver 2 (현재)](https://github.com/choijw1004/Algorithm/tree/main/src/ver2)
---

## Algorithm 분류

"""


    for category in sorted(problems_by_category.keys()):
        content += f"## {category}\n"
        
        for problem in problems_by_category[category]:
            content += f"- [{problem['name']}]({problem['path']})\n"
        
        content += "\n"
    
    return content


def main():
    problems_by_category = {}
    
    if not os.path.exists(PROBLEMS_DIR):
        os.makedirs(PROBLEMS_DIR)
        return
    
    for problem_name in os.listdir(PROBLEMS_DIR):
        problem_path = Path(PROBLEMS_DIR) / problem_name
        
        if not problem_path.is_dir():
            continue
        
        readme_file = problem_path / 'README.md'
        if not readme_file.exists():
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
    with open(README_PATH, 'w', encoding='utf-8') as f:
        f.write(main_readme)


if __name__ == '__main__':
    main()