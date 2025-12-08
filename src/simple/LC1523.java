package simple;

public class LC1523 {
    public static void main(String[] args) {
        LC1523 solution = new LC1523();
        System.out.println(solution.countOdds(3, 7));   
    }
    public int countOdds(int low, int high) {
        int ans = (high - low) / 2;
        // 1. 一奇一偶：(high - low) / 2 + 1
        // 2. 两奇数：(high - low) / 2 + 1
        // 3. 两偶数：(high - low) / 2
        if((high - low) % 2 == 1 || high % 2 == 1){
            ans++;
        }
        return ans;
    }
}
