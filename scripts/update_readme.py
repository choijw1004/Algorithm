import os
import re
from pathlib import Path

PROBLEMS_DIR = './src/ver2'
README_PATH = './README.md'


def parse_problem_file(file_path):
    with open(file_path, 'r', encoding='utf-8') as f:
        content = f.read()
    
    comment_match = re.search(r'/\*\s*([\s\S]*?)\s*\*/', content)

    if not comment_match:
        return None
    
    comment = comment_match.group(1)
    
    category_match = re.search(r'# 카테고리\s*\n([^\n#]+)', comment)
    categories = []
    
    if category_match:
        categories = [c.strip() for c in category_match.group(1).split(',') if c.strip()]
    
    approach_match = re.search(r'# 접근 방식\s*\n([\s\S]*?)(?=\n# |$)', comment)
    approach = approach_match.group(1).strip() if approach_match else ''
    
    link_match = re.search(r'# 문제 링크\s*\n([^\n]+)', comment)
    problem_link = link_match.group(1).strip() if link_match else ''
    
    code = re.sub(r'/\*[\s\S]*?\*/', '', content).strip()
    
    return {
        'categories': categories,
        'approach': approach,
        'problem_link': problem_link,
        'code': code
    }


def generate_problem_readme(problem_name, metadata):
    categories_str = ' '.join([f'`{c}`' for c in metadata['categories']])
    
    return f"""# {problem_name}

## 문제 링크
{metadata['problem_link']}

## 카테고리
{categories_str}

## 접근 방식
{metadata['approach']}

## 코드
```java
{metadata['code']}
```
"""


def generate_main_readme(problems_by_category):
    # 고정 헤더
    content = """# Algorithm, PS Repository

- [Github Actions 적용 전 repository ver 1](https://github.com/choijw1004/Algorithm/tree/main/src/ver1)
- [Github Actions 적용 후 repository ver 2 (현재)](https://github.com/choijw1004/Algorithm/tree/main/src/ver2)
---

## Algorithm 분류

---
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
        
        java_files = list(problem_path.glob('*.java'))
        if not java_files:
            continue
        
        metadata = parse_problem_file(java_files[0])
        if not metadata:
            continue
        
        # 개별 문제 README 생성
        problem_readme = generate_problem_readme(problem_name, metadata)
        with open(problem_path / 'README.md', 'w', encoding='utf-8') as f:
            f.write(problem_readme)
        
        # 카테고리 분류
        readme_path = f"./src/ver2/{problem_name}/README.md"
        for category in metadata['categories']:
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