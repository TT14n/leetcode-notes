import random
import time
def quick_sort_sol1(lists,i,j):
    if i >= j:
        return lists
    pivot = lists[i]
    low = i
    high = j
    while i < j:
        while i < j and lists[j] >= pivot:
            j -= 1
        lists[i]=lists[j]
        while i < j and lists[i] <=pivot:
            i += 1
        lists[j]=lists[i]
    lists[j] = pivot
    quick_sort_sol1(lists,low,i-1)
    quick_sort_sol1(lists,i+1,high)
    return lists

def quick_sort_sol2(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[0]
    left = [x for x in arr[1:] if x < pivot]
    right = [x for x in arr[1:] if x >= pivot]
    return quick_sort_sol2(left) + [pivot] + quick_sort_sol2(right)
    
if __name__=="__main__":
    # 随机生成长度为10000的数组
    n = 1000000
    random.seed(42)  # 设置随机种子，确保两次运行结果一致
    test_arr = [random.randint(1, 100000) for _ in range(n)]
    
    print(f"生成了长度为 {n} 的随机数组")
    print(f"前10个元素: {test_arr[:10]}")
    print("-" * 60)
    
    # 测试方法1：quick_sort_sol1（原地排序，需要复制数组）
    arr1 = test_arr[:]
    start_time = time.time()
    result1 = quick_sort_sol1(arr1, 0, len(arr1) - 1)
    time1 = time.time() - start_time
    
    # 测试方法2：quick_sort_sol2（返回新数组）
    arr2 = test_arr[:]
    start_time = time.time()
    result2 = quick_sort_sol2(arr2)
    time2 = time.time() - start_time
    
    # 使用Python内置sorted作为标准答案
    expected = sorted(test_arr)
    
    # 验证正确性
    is_correct1 = result1 == expected
    is_correct2 = result2 == expected
    
    print("测试结果:")
    print(f"方法1 排序时间: {time1:.6f} 秒")
    print(f"方法2 排序时间: {time2:.6f} 秒")
    print(f"方法1 排序结果: {'正确' if is_correct1 else '错误'}")
    print(f"方法2 排序结果: {'正确' if is_correct2 else '错误'}")
    print("-" * 60)
    
    # 打印排序前后的前10个元素
    print("排序前前10个元素:")
    print(test_arr[:10])
    print("排序后前10个元素:")
    print(result1[:10] if is_correct1 else result2[:10])
