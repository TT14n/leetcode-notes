package math;
public class LC287_sol1 {
    public static void main(String[] args) {
        LC287_sol1 solution = new LC287_sol1();
        System.out.println(solution.findDuplicate(new int[]{1,3,4,2,2}));
        
    }
    public int findDuplicate(int[] nums) {
        int l = 1, r = nums.length;
        // 1 2 2 3 4 nums
        // 1 3 3 4 5 nums[i]>=其余的数量 cnt 
        while (l<r) {
            int mid = (l+r)/2;
            int cnt = 0;
            // 统计<=mid的数的数量
            for(int x : nums){
                if(mid >= x){
                    cnt++;
                }
            }
            
            // 如果 cnt > mid
            if(cnt > mid){
                r = mid;
            }else{
                l = mid+1;
            }
        }

        return l;
    }
}
