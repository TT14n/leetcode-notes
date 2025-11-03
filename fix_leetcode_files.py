import os
import re
from pathlib import Path

def fix_java_file(file_path):
    """修复单个Java文件，使类名与文件名匹配"""
    # 从文件名提取类名 (例如: LC3541.java -> LC3541)
    class_name = Path(file_path).stem
    
    # 读取文件内容
    with open(file_path, 'r', encoding='utf-8') as f:
        content = f.read()
    
    # 检查是否已经是public class
    if f'public class {class_name}' in content:
        print(f"  [SKIP] {file_path} 已经是正确的格式")
        return False
    
    # 替换 class Solution 为 public class LCxxx
    # 使用正则表达式匹配 class Solution（可能有static修饰符）
    pattern = r'\bclass\s+Solution\s*\{'
    if re.search(pattern, content):
        content = re.sub(pattern, f'public class {class_name} {{', content)
        
        # 替换所有的 new Solution() 为 new LCxxx()
        content = re.sub(r'\bnew\s+Solution\s*\(', f'new {class_name}(', content)
        
        # 替换 Solution sol 或 Solution solution 为 LCxxx sol/solution
        content = re.sub(r'\bSolution\s+sol\s*=', f'{class_name} sol =', content)
        content = re.sub(r'\bSolution\s+solution\s*=', f'{class_name} solution =', content)
        
        # 写回文件
        with open(file_path, 'w', encoding='utf-8') as f:
            f.write(content)
        
        print(f"  [FIXED] {file_path}")
        return True
    else:
        print(f"  [WARN] {file_path} 没有找到 'class Solution'")
        return False

def main():
    """批量处理所有LC*.java文件"""
    print("开始批量修复LeetCode Java文件...\n")
    
    # 获取src目录
    src_dir = Path('src')
    if not src_dir.exists():
        print("错误: 找不到src目录")
        return
    
    # 查找所有LC*.java文件
    java_files = list(src_dir.rglob('LC*.java'))
    
    if not java_files:
        print("没有找到任何LC*.java文件")
        return
    
    print(f"找到 {len(java_files)} 个文件\n")
    
    fixed_count = 0
    skipped_count = 0
    
    for java_file in sorted(java_files):
        if fix_java_file(java_file):
            fixed_count += 1
        else:
            skipped_count += 1
    
    print(f"\n{'='*60}")
    print(f"处理完成！")
    print(f"  修复: {fixed_count} 个文件")
    print(f"  跳过: {skipped_count} 个文件")
    print(f"{'='*60}")

if __name__ == '__main__':
    main()

