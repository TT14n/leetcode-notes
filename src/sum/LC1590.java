package sum;
import java.util.HashMap;

public class LC1590 {
    public int minSubarray(int[] nums, int p) {
        // total mod k = r 
        // 然后求解前缀和为 mod k = r 的最短数组
        // 长度不能为 n
        int n = nums.length;
        long[] sum = new long[n+1]; // 从 1 开始
        sum[0] = 0;
        for(int i=1; i<=n; i++){
            sum[i] = (sum[i-1] + nums[i-1]) % p;
        }

        long r = sum[n];
        int ans = n;
        // key 为 mod k 的结果，val 为最近的 index
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 0);
        // 从 0 开始，兼容一开始就是 r=0 的情况
        for(int i=0; i<=n; i++){
            // 判断是否能组成和模为 r 的子数组
            long key = (sum[i] + p - r) % p;
            // System.out.println(i + " " + key + " " + map);
            if(map.containsKey(key)){
                ans = Math.min(ans, i-map.get(key));
            }
            map.put(sum[i], i);
            
        }

        return ans == n ? -1 : ans;
    }
    public static void main(String[] args) {
        LC1590 solution = new LC1590();
        System.out.println(solution.minSubarray(new int[]{1,2,3}, 3));

    }
}
