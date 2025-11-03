package dp;

import java.util.Arrays;
public class LC3685 {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        // 不是滑动窗口（滑动窗口得是连续的，这是子序列）
        // 动态规划？选或者不选，0-1 背包？
        boolean[] result = new boolean[nums.length];
        Arrays.sort(nums);
        // 0-1 背包，需要进行优化
        // sort 排序
        int[] dp = new int[k+1];
        dp[0] = 1;
        int i=0;
        for (int x=1; x <= nums.length; x++){
            while(i<nums.length && nums[i] <= x) {
                // 01 背包
                for(int j=k; j>=nums[i]; j--){
                    dp[j] |= dp[j-nums[i]];
                }
                i++;
            }
            // 判断大于x的数值（个数为 nums.length-i）
            boolean flag = false;
            for(int j=0; j<nums.length-i+1 && k-j*x>=0; j++){
                if (dp[k-j*x]==1){
                    flag = true;
                    break;
                }
            }
            result[x-1] = flag;
        }
        return result;

    }

    public static void main(String[] args) {
        LC3685 sol = new LC3685();
        boolean[] result = sol.subsequenceSumAfterCapping(new int[]{11,12,2,8,4,19,10,10,14,20,17,10,2,13,20,15,20,9,13,16}, 6);
        for (boolean x: result){
            System.out.print(x + " ");
        }
    }
}

