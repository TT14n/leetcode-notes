package dp;

public class LC2110 {
    public long getDescentPeriods(int[] prices) {
        long ans = 1;
        int cnt = 1;
        for(int i=1; i<prices.length; i++){
            if(prices[i] == prices[i-1] - 1){
                cnt++;
            }else{
                cnt = 1;
            }
            ans += cnt;
        }
        return ans;
    }
}
