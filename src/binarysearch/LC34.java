package binarysearch;
import slidingwindow.LC3;

public class LC34 {
    
    int firstPos(int[] nums, int target){
        if(nums.length == 0){
            return -1;
        }
        int l=0, r=nums.length-1;
        while(l < r){
            int mid = (l+r)/2;
            if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return nums[l] == target ? l : -1;
    }
    int lastPos(int[] nums, int target){
        if(nums.length == 0){
            return -1;
        }
        int l=0, r=nums.length-1;
        while(l < r){
            int mid = (l+r+1)/2;
            if(nums[mid] > target){
                r = mid-1;
            }else{
                l = mid;
            }
        }

        return nums[l] == target ? l : -1;

    }
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = firstPos(nums, target);
        result[1] = lastPos(nums, target);
        return result;
        
    }
    public static void main(String[] args) {
        LC34 solution = new LC34();
        int[] result = solution.searchRange(new int[]{5,7,7,8,8,10}, 8);
        System.out.println(result[0] + " " +  result[1]);
    
    }


}
