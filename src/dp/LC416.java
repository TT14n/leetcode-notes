package dp;
public class LC416 {
    public static void main(String[] args) {
        LC416 solution = new LC416();
        System.out.println(solution.canPartition(new int[]{2,2,3,5}));
    }
    
    public boolean canPartition(int[] nums) {
        // 0-1 背包，注意从大到小
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }

        if(sum % 2 == 1){
            return false;
        }

        int target = sum/2;
        int[] f = new int[target + 1];
        f[0] = 1;
        int maxv = 0;
        for (int i = 0; i < nums.length; i++) {
            maxv += nums[i];
            for(int v = Math.min(maxv, target); v >= nums[i]; v--){
                f[v] |= f[v-nums[i]];
            }
        }

        return f[target] == 1 ? true : false;
    }
}