public class LC33 {
    public static void main(String[] args) {
        LC33 solution = new LC33();
        System.out.println(solution.search(new int[]{5,7,8,0,3,4}, 7));
    }

    public int search(int[] nums, int target) {
        // 确定旋转位置
        int l=0, r=nums.length-1;
        while(l < r){
            int mid = (l+r)/2;
            // System.out.println(l + " " + r + " " + mid + " " + nums[mid] + " " + target);
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] >= nums[0]){
                if(nums[mid] > target && target >= nums[0]){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }else{
                if(nums[mid] < target && target < nums[0]){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }
            
        }
        return nums[l] == target ? l : -1;
        
    }
}
