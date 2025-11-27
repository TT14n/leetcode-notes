package sum;
import java.util.HashMap;

public class LC560 {
    public static void main(String[] args) {
        LC560 solution = new LC560();
        System.out.println(solution.subarraySum(new int[]{1,-1,0}, 0));
    }
    public int subarraySum(int[] nums, int k) {
        // 前缀和 + 哈希表
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int ans = 0;
        for(int num : nums){
            sum += num;
            ans += map.getOrDefault(sum-k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
