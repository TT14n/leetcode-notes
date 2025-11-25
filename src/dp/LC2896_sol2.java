package dp;
import java.util.*;
import java.util.stream.*;


public class LC2896_sol2 {
    public static void main(String[] args) {
        LC2896_sol2 solution = new LC2896_sol2();
        System.out.println(solution.minOperations("1100011000", "0101001010", 2));
    }
    public int minOperations(String s1, String s2, int x) {
        // 正规的 dp
        // 只考虑 1 不同的情况
        // List<Integer> p = IntStream.range(0, s1.length())
        //     .filter(i -> s1.charAt(i)!=s2.charAt(i))
        //     .boxed()
        //     .collect(Collectors.toList());
        int[] p = IntStream.range(0, s1.length())
            .filter(i -> s1.charAt(i)!=s2.charAt(i))
            .toArray();
        
        // 如果不同的数量不为偶数，则返回 -1
        if(p.length % 2 != 0){
            return -1;
        }
        // dp
        // 因为第二种方案一定翻转两次，所以第一种方案也肯定会执行两次
        // 因此第一种方案可以拆开来看，每次的代价为 x/2
        // 为了方便处理，则统一先 *2，后续再统一 /2
        int[] dp = new int[p.length+1];
        for (int i = 1; i <= p.length; i++) {
            // 尝试第一种翻转方案
            dp[i] = dp[i-1] + x; 
            if(i>=2){ // 对比第二种方案
                int j = i - 1;
                dp[i] = Math.min(dp[i], dp[i-2] + (p[j] - p[j-1]) * 2);
            } 
        }
        return dp[p.length]/2;
    }

   
}
 