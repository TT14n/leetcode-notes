package dp;

import java.util.*;
public class LC139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 由于问题问的是：前 n 个字符是否能被拆分，所以只需要一维 dp
        // dp[r] 表示从 [0, r) 的情况
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;

        // l=0 为左区间
        // r 表示右区间
        for(int r=1; r<=n; r++){
            // k 表示中间值分隔区间
            for (String word : wordDict){
                if(word.length() > r){
                    continue;
                }
                int j = r-word.length();
                if(dp[j] == 1 && s.startsWith(word, j)){
                    dp[r] = 1;
                    break;
                }
            }
        }

        return dp[n] == 1;
    }

}
