package binarysearch;

public class LC35 {
    // 找到第一个 < target 的位置
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l < r) {
            int mid = (l+r+1)/2;
            if(nums[mid] < target){
                l = mid;
            }else{
                r = mid-1;
            }
        }
        if(nums[l] < target){
            return l + 1;
        }else{
            return l;
        }
        
    }
}
