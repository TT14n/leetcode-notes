package dp;
import java.util.*;

public class LC2435 {
    public static void main(String[] args) {
        LC2435 solution = new LC2435();
        int result = solution.numberOfPaths(new int[][]{{5,2,4},{3,0,5},{0,7,2}}, 3);
        System.out.println(result);
    }

    public int numberOfPaths(int[][] grid, int k) {
        int mod = 10_0000_0000 + 7;
        int n = grid.length; // 行   
        int m = grid[0].length; // 列
        int isSwap = n >= m ? 0 : 1; // 默认一行一行往下dp，但是 m 较大时，使用列dp
        if(isSwap == 1){
            int tmp = n; n = m; m = tmp;
        }
        
        // 初始化
        // ArrayList<HashMap<Integer, Integer>> dp = new ArrayList<>(m+1);
        int[][] dp = new int[m+1][k];
        dp[0][0] = 1;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num;
                if(isSwap == 0){
                    num = grid[i][j];
                }else{
                    num = grid[j][i];
                }
                
                int[] newDp = new int[k];
                // 往右
                accumulate(dp, num, k, j, newDp, mod);
                // 往下
                accumulate(dp, num, k, j+1, newDp, mod);
                
                // dp.set(j+1, newDp);
                for(int t=0; t<k; t++){
                    dp[j+1][t] = newDp[t];
                }
                System.out.println(i + " " + j + " " + isSwap + " " + Arrays.toString(newDp));
            }

            // 清除起始点的初始值
            if(i == 0){
                dp[0][0] = 0;
            }
        }

        return dp[m][0];
    }

    private void accumulate(int[][] dp, int num, int k, int pos, int[] newDp, int mod){
        for(int t=0; t<k; t++){
            int newT = (t + num) % k;
            // System.out.println(t + " " + num + " " + dp[pos][newT]);
            newDp[newT] = (newDp[newT] + dp[pos][t]) % mod; 
        }
    
    }
}
