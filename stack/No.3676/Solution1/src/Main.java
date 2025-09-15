import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public long bowlSubarrays(int[] nums) {
        // 栈的作用，是找到第一个 >=当前值x的值
        // 分类讨论
        Deque<Integer> stack = new ArrayDeque<>();
        int result=0;
        for(int i=0; i<nums.length; i++){
            int x = nums[i];
            while(!stack.isEmpty() && nums[stack.peek()] < x){
                int j = stack.pop();
                // nums[l] < nums[r]，且中间有值
                if(i-j > 1){
                    result++;
                }
            }
            // nums[l] >= nums[r]，且中间有值
            // 再往前的 l 不考虑，因为已经有值 >= nums[r] 了
            if(!stack.isEmpty() && i-stack.peek() > 1){
                result++;
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        long result = sol.bowlSubarrays(new int[]{2,5,3,1,4});
        System.out.println(result);
    }
}