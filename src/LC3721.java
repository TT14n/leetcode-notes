import java.util.HashMap;

public class LC3721 {
    public static void main(String[] args) {

    }
    public int longestBalanced(int[] nums) {
        // 存储第一次出现某个状态的位置，当第二次出现时，说明中间的数组是符合题意的？
        // 不对，第一次出现的数是在子数组中的，在数组中出现的数，在子数组中不一定出现
        
        // 遍历右端点
        // 考虑到第一次出现的情况，应该将最近出现的数视为第一次出现（因为确定了右端点，是逐步往左判定是否符合题意）
        // 奇数 +，偶数 - 
        // 当在区间为 [0, i] 的情况下，如奇数 num 第一次出现在 i，则 [i, n] 均 + 1 
        // 而在区间为 [0, j] 的情况下，j > i，若  num 再一次出现在 j，则 [i, j-1] 均 -1（即撤销之前的改动）

        // 我们需要维护一个动态变化的前缀和数组，需要一个数据结构，支持：
        // 1. 把 sum 的某个子数组增加 1 或者 −1。
        // 2. 查询 sum[i] 在 sum 中首次出现的位置。

        HashMap<Integer, Boolean> cntMap = new HashMap<>();
        HashMap<Integer, Integer> stateMap = new HashMap<>(); 
        int ans = 0;
        int state = 0; // 奇数+，偶数-
        stateMap.put(0, -1);
        for(int i=0; i<nums.length; i++){
            if(!cntMap.containsKey(nums[i])){ // 第一出现的数
                cntMap.put(nums[i], true); 
                state += nums[i] % 2 == 1 ? 1 : -1;
            }
            if(!stateMap.containsKey(state)){
                
            }
            ans = Math.max(ans, i-stateMap.get(state));
        }

        return ans;
    }

}
