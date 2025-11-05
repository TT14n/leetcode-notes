package dp;
import java.util.TreeMap;
import java.util.Map;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC2902 {
    public int countSubMultisets(List<Integer> nums, int l, int r) {
        // n = 2*10^4, nlogn 级别的算法
        // 有序 hashmap 存储数组的值数量（或是排序？==> 滑动窗口×不连续）
        // 动态规划？ dp[] 0,1背包 ==> n^2
        // 每一组方案的区别在于 数值和数量 的变化
        int MOD=10_0000_0000 + 7;
        int[] dp = new int[r+10];
        dp[0] = 1;

        Map<Integer, Integer> map = new TreeMap<>();
        for(int num : nums){
            if(num == 0){
                dp[0]++;
                continue;
            }
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        // 朴素的多重背包，以元素x=2, 数目cnt[x]=3为例
        // dp[i][j] = dp[i-1][j] + dp[i-1][j-2] + dp[i-1][j-4] + dp[i-1][j-6]

        // 优化的多重背包，使用dp[i][j-2]进行简化重复计算，以O(1)得出dp[i][j]
        // dp[i][j] = dp[i-1][j] + dp[i][j-2] - dp[i][j-8]
        // 即
        // dp[i][j] = dp[i-1][j] + dp[i][j-x] - dp[i][j-x*(cnt[x]+1)]
        // -的这项是为了剔除dp[i][j-x]中累加的，但是未包含在dp[i][j]中的，当 j-x*(cnt[x]+1) < 0 时，dp[i][j-x] 并没有累积，自然不需要剔除
        // 于是退化为 dp[i][j] = dp[i-1][j] + dp[i][j-x]

        // 使用优化的多重背包
        // 复杂度：O(MAX*num数目) = O(nm)，其中n<=4*10^4, m<=200;
        int maxx = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int num=entry.getKey(), cnt=entry.getValue();
            int[] oldDp = dp.clone();
            maxx = Math.min(r, maxx + num*cnt);
            for(int j=num; j<=maxx; j++){
                // 换一种角度理解，可以视作在求同余前缀和
                dp[j] = (dp[j] + dp[j-num]) % MOD;
                if(j >= num*(cnt+1)){
                    dp[j] = (dp[j] - oldDp[j-num*(cnt+1)] + MOD) % MOD;
                }
            }
        
        }

        // 返回 l 到 r 的结果 
        int result = 0;
        for(int j=l; j<=r; j++){
            result = (result + dp[j]) % MOD;
        }
        return result;
    }

    public static void main(String[] args) {
        LC2902 solution = new LC2902();
        System.out.println(solution.countSubMultisets(new LinkedList<>(Arrays.asList(2, 2, 3, 2)), 5, 9));
    }
}
