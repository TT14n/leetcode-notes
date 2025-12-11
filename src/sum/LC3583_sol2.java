package sum;
import java.util.HashMap;

public class LC3583_sol2 {
    public static void main(String[] args) {
         LC3583_sol1 solution = new LC3583_sol1();
         System.out.println(solution.specialTriplets(new int[]{22,90,11,22,44,88}));
    }
    public int specialTriplets(int[] nums) {
        // 使用 map
        // 枚举中间
        HashMap<Integer, Integer> suf = new HashMap<>();
        for(int num : nums){
            suf.merge(num, 1, (oldVal, newVal) -> Integer.sum(oldVal, newVal));
        }
        
        // 枚举中间值
        HashMap<Integer, Integer> pre = new HashMap<>();
        long ans = 0;
        int mod = 10_0000_0000 + 7;
        for(int num : nums){
            // suf表示：[i+1, n]
            suf.merge(num, -1, Integer::sum); 
            
            ans = ((long)pre.getOrDefault(num*2, 0) * suf.getOrDefault(num*2, 0) + ans) % mod;

            // pre表示：[0, i-1]
            pre.merge(num, 1, Integer::sum);

        }
        
        return (int)ans;
    }
}
