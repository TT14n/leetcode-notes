import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public long bowlSubarrays(int[] nums) {
        // 栈的作用，是找到第一个 >=当前值x的值
        // 只要有弹出，就说明中间有值，与当前栈顶可以组成碗
        Deque<Integer> stack = new ArrayDeque<>();
        int result=0;
        for(int i=0; i<nums.length; i++){
            int x = nums[i];
            while(!stack.isEmpty() && nums[stack.peek()] < x){
                stack.pop();
                // 需要有栈顶
                if(!stack.isEmpty()) result++;
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