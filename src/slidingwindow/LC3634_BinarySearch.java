package slidingwindow;

import java.util.Arrays;

public class LC3634_BinarySearch {
    public int minRemoval(int[] nums, int k) {
        // 二分查找
        Arrays.sort(nums);
        int left = 0, right = nums.length-1;
        int result = 0;
        while (left <= right) {
            int i = binarySearch(nums, (long)nums[left]*k, left, right);
            int j;
            // 因为这里是找第一个大于 x 的函数，所以需要做一些特殊的处理
            if (nums[right] % k==0){
                j = binarySearch(nums, nums[right]/k-1, left, right);
            }else{
                j = binarySearch(nums, nums[right]/k, left, right);
            }

            if(i == right+1){
                return result;
            }
//            System.out.println(left + " " + right);
//            System.out.println(i + " " + j);
//            System.out.println(i-left + " " + (right-j+1));
            if (i-left > right-j+1){
                right--;
            }else{
                left++;
            }
            result++;
        }
        return result;

    }
    // 找到第一个 >x 的数的索引
    private int binarySearch(int[] nums, long x, int leftBound, int rightBound) {
        int left = leftBound, right = rightBound;
        if(nums[right] <= x) return rightBound+1;
        while (left < right) {
            int mid = (left+right)/2;
            if(nums[mid] > x){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        LC3634_BinarySearch sol = new LC3634_BinarySearch();
        int[] nums = {272,410,410};
        System.out.println(sol.minRemoval(nums, 1 ));
    }
}







