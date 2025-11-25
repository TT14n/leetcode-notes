package dp;
public class LC72 {
    public static void main(String[] args) {
        LC72 solution = new LC72();
        System.out.println(solution.minDistance("", "ros"));
    }
    public int minDistance(String word1, String word2) {
        // 二维 DP
        int n = word1.length();
        int m = word2.length();
        int inf = Math.max(n, m) + 100;
        int[][] dp = new int[n+1][m+1];


        // 从 1 开始，存在空字串时，可以通过删除和插入变成另一个子串
        for(int i=0; i<=n; i++)
            dp[i][0] = i;
        for(int j=0; j<=m; j++)
            dp[0][j] = j;
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                dp[i][j] = inf;
                // 插入
                dp[i][j] = Math.min(dp[i][j], dp[i][j-1]+1);
                // 删除
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+1);
                // 相等
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
                }else{ // 替换
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]+1);
                }   
                // System.out.print(dp[i][j] + " ");
            }
            // System.out.println();
            
        }
        return dp[n][m];
    }
}
