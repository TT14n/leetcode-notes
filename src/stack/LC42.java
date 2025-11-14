package stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class LC42 {
     // 单调递减栈
     public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        for(int i=0; i<height.length; i++){
            while(!stack.isEmpty() && height[stack.peek()] <= height[i]){
                int idx = stack.pop();
                if(!stack.isEmpty()){
                    result += (i-stack.peek()-1) * (Math.min(height[stack.peek()], height[i]) - height[idx]);
                }
            }
            stack.push(i);

        }
        return result;
    }
    public static void main(String[] args) {
        LC42 solution = new LC42();
        System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    
    }
}
