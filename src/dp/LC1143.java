package dp;

import java.util.HashMap;
import java.util.LinkedList;

public class LC1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] charArray1 = text1.toCharArray();
        int n = charArray1.length;
        char[] charArray2 = text2.toCharArray();
        int m = charArray2.length;
        int[][] dp = new int[n+1][m+1];

        // 大问题：长度为 n 的字符串和长度为 m 的字符串的最大子序列
        // 化为小问题：长度为 i+1 的字符串和长度为 j+1 的字符串的最大子序列
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(charArray1[i] == charArray2[j]){
                    // 相等，则取 dp[i][j]+1 的结果
                    dp[i+1][j+1] = dp[i][j]+1;
                }else{
                    // 如果不相等，则取 dp[i][j+1] 和 dp[i+1][j] 中较大的结果
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }


        return dp[n][m];
    }
}
