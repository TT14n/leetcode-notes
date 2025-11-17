package dp;
public class LC2770 {
    public static void main(String[] args) {
        LC2770 solution = new LC2770();
        System.out.println(solution.maximumJumps(new int[]{1,3,6,4,1,2}, 0));
    }
    public int maximumJumps(int[] nums, int target) {
        // 从后往前跳
        int n = nums.length;
        int[] f = new int[n];
        f[n-1] = 0;
        for(int i=n-2; i>=0; i--){
            f[i] = -1;
            for(int j=i+1; j<n; j++){
                if(f[j] != -1 && Math.abs(nums[j] - nums[i]) <= target){
                    f[i] = Math.max(f[i], f[j]+1);
                }
            }
        }
        return f[0];
    }
}
