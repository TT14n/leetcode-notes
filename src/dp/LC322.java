package dp;

public class LC322 {
    public int coinChange(int[] coins, int amount) {
        final int inf = amount+1;
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1; i<=amount; i++){
            dp[i] = inf;
        }

        for(int coin : coins){
            for (int v=coin; v<=amount; v++){
                dp[v] = Math.min(dp[v], dp[v-coin]+1);
            }
        }

        return dp[amount] == inf ? -1 : dp[amount];


    }
}
