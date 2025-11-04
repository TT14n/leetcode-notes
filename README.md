# LeetCode 刷题笔记

本项目整理了所有已完成的 LeetCode 题目，按算法分类组织，便于复习和查找。

## 项目结构

```
leetcode-notes/
├── src/
│   ├── sum/           # 前缀和相关题目
│   ├── dp/            # 动态规划
│   ├── heap/          # 堆
│   ├── hash/          # 哈希表
│   ├── stack/         # 栈
│   ├── slidingwindow/ # 滑动窗口
│   ├── simple/        # 简单题
│   ├── sort/          # 排序
│   ├── greedy/        # 贪心
│   └── math/          # 数学
└── README.md
```

## 如何运行

每个 Java 文件都可以独立运行：
1. 在 IDEA 中打开项目
2. 右键点击任意 `.java` 文件
3. 选择 `Run 'Solution.main()'` 或使用快捷键

## 题目列表

### 前缀和 (sum/)
- **LC1480** - Running Sum of 1d Array
- **LC1310** - XOR Queries of a Subarray
- **LC1732** - Find the Highest Altitude
- **LC1862** - Sum of Floored Pairs
- **LC238** - Product of Array Except Self
- **LC304** - Range Sum Query 2D - Immutable
- **LC974** - Subarray Sums Divisible by K
- **LC209** - Minimum Size Subarray Sum
  - LC209_SlidingWindow - 滑动窗口解法 O(N)
  - LC209_BinarySearch - 二分查找解法 O(N log N)
- **LC1442** - Count Triplets That Can Form Two Arrays of Equal XOR
  - LC1442_Solution1 - 三层循环 O(N³)
  - LC1442_Solution2 - 双层循环 O(N²)
  - LC1442_Solution3 - 哈希表优化 O(N)
- **LCR008** - 和大于等于 target 的最短子数组
- **LCR010** - 和为 K 的子数组
- **LCR011** - 连续数组

### 动态规划 (dp/)
- **LC3685** - Subsequence Sum After Capping (0-1背包)
- **LC3686** - Count Stable Subsequences
- **LC729** - My Calendar I

### 堆 (heap/)
- **LC3408** - Task Manager (优先队列)
- **LC2349** - Subarray GCD
  - LC2349_Solution1 - 滑动窗口 + GCD
  - LC2349_Solution2 - TreeSet解法

### 哈希表 (hash/)
- **LC966** - Count Binary Palindromes (位运算 + 数学)

### 栈 (stack/)
- **LC2197** - Replace Non-Coprime Numbers (单调栈 + GCD)
- **LC3676** - Bowl Subarrays
  - LC3676_Solution1 - 分类讨论
  - LC3676_Solution2 - 简化版本

### 滑动窗口 (slidingwindow/)
- **LC1234** - Replace the Substring for Balanced String
- **LC611** - Valid Triangle Number
- **LC3634** - Minimum Removal to Make Array Equal
  - LC3634_BinarySearch - 二分查找
  - LC3634_SlidingWindow - 滑动窗口

### 简单题 (simple/)
- **LC165** - Compare Version Numbers
- **LC1935** - Maximum Number of Words You Can Type
- **LC3541** - Max Frequency Sum
- **LC3674** - Min Operations (数组)
- **LC3675** - Min Operations (字符串)
- **LC3683** - Earliest Time to Complete Tasks

### 排序 (sort/)
- **LC2785** - Sort Vowels in a String
- **LC3684** - Max K Distinct Elements

### 贪心 (greedy/)
- **LC3674** - Alice Wins Game

### 数学 (math/)
- **LC1104** - Path In Zigzag Labelled Binary Tree
- **LC3677** - Count Binary Palindromes (位运算)

## 统计

- **总题数**: 40+ 道
- **多解法题目**: LC209, LC1442, LC2349, LC3634, LC3676
- **覆盖类型**: 前缀和、动态规划、堆、哈希、栈、滑动窗口、排序、贪心、数学

## 更新日志

- 2025-11-03: 重构项目结构，简化为单一模块 + 包结构
- 所有文件添加 package 声明，支持独立编译运行
- 文件命名优化为 `LC题号_说明.java` 格式

## 备注

- 所有代码均在 IDEA 中测试通过
- 每个文件包含 `main` 方法用于测试
- 注释保留了解题思路和复杂度分析







