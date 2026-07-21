package dp;

public class LC64 {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        int inf = 10000;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                dp[i][j] = inf;
            }
        }
        dp[0][0] = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i > 0){
                    dp[i][j] = Math.min(dp[i-1][j]+grid[i][j], dp[i][j]);
                }
                if(j > 0){
                    dp[i][j] = Math.min(dp[i][j-1]+grid[i][j], dp[i][j]);
                }

            }
        }

        return dp[n-1][m-1];
    }
}
