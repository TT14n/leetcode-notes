class Solution {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        // 不是滑动窗口（滑动窗口得是连续的，这是子序列）
        // 动态规划？选或者不选，0-1 背包？
        boolean[] result = new boolean[nums.length];
        for (int x = 1; x <= nums.length; x++){
            int[] dp = new int[k+1];
            dp[0] = 1;
            for(int i=0; i<nums.length; i++){
                int v = Math.min(nums[i], x);
                // 0-1 背包
                for(int j=k; j>=v; j--){
                    dp[j] |= dp[j-v];
                }
                if(dp[k]==1) break;
            }
            result[x-1] = dp[k]==1;
        }
        return result;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean[] result = sol.subsequenceSumAfterCapping(new int[]{11,12,2,8,4,19,10,10,14,20,17,10,2,13,20,15,20,9,13,16}, 6);
        for (boolean x: result){
            System.out.print(x + " ");
        }
    }
}