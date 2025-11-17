package dp;
public class LC198 {
    public static void main(String[] args) {
        LC198 soulution = new LC198();
        System.out.println(soulution.rob(new int[]{1,2,3,1}));
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        if(n > 1) {
            f[1] = Math.max(f[0], nums[1]);
        }
        for(int i=2; i<nums.length; i++){
           f[i] = Math.max(f[i-1], f[i-2] + nums[i]);
        }
        return f[n-1];
    }
}
