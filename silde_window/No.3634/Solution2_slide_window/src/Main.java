import java.util.Arrays;

class Solution {
    public int minRemoval(int[] nums, int k) {
        // 滑动窗口
        Arrays.sort(nums);
        // 转换思路，从删除两边的元素，转换成找最长的连续序列
        int maxLength = 0;
        int left = 0;
        for(int right=0; right<nums.length; right++){
            while ((long)nums[left]*k < nums[right]){
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
        }
        return nums.length-maxLength;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {272,410,410};
        System.out.println(sol.minRemoval(nums, 1 ));
    }
}