package stack;

public class LC121 {
    public int maxProfit(int[] prices) {
        // 寻找最好的买入时机
        int pre = 100_0000;
        int ans = 0;
        for(int price : prices){
            if(pre > price){
                // 不买之前的股票，买这一只
                pre = price;
            }else {
                // 计算可能的收益
                ans = Math.max(price - pre, ans) ;
            }
        }
        return ans;
    }
}
