package dp;

import java.util.Arrays;

public class LC300 {
    public int lengthOfLIS(int[] nums) {
        // dp[i] 表示如果长度是为 i+1 的序列中，最后一个值最小为多少
        int n = nums.length;
        final int inf = 100_0000;
        int[] dp = new int[n+1];
        int maxLen = 0;

        Arrays.fill(dp, inf);
        dp[0] = -inf;

        for(int i=0; i<n; i++){
            if(nums[i] > dp[maxLen]){
                dp[++maxLen] = nums[i];
            }else{
                // 寻找 nums[i] <= dp[j]
                int j = search(nums[i], dp, maxLen);
                dp[j] = nums[i];
            }
        }
        return maxLen;
    }

    public int search(int target, int[] dp, int r){
        int l = 1;
        int mid;
        // 寻找第一个数 >= target，因为是严格递增，所以判断条件是 >= 而非 >
        // 意思是如果存在相同的数，那就只更新那个相同的数，而不会出现 0 0 1 2 这种非严格递增的情况
        while (l < r){
            mid = (l + r) / 2;
            if(dp[mid] >= target){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
}
