package stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
public class LC2197 {
    int gcd(int a, int b) {
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
        // 使用栈存储结果
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<nums.length; i++){
            int lcm = nums[i];
            int g;
            while(!stack.isEmpty()){
                g = gcd(lcm, stack.peek());
//                System.out.println(nums[i] + " " + stack.peek() + " " + g);
                if(g == 1) {
                    break;
                }
                lcm = stack.pop() / g * lcm;
            }
            stack.push(lcm);
        }
        return new ArrayList<>(stack.reversed());
    }

    public static void main(String[] args) {
        LC2197 sol = new LC2197();
        int[] nums = {287,41,49,287,899,23,23,20677,5,825};
        List<Integer> result = sol.replaceNonCoprimes(nums);
        System.out.println(result);
    }
}

