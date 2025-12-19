package deque;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LC239 {

    public static void main(String[] args) {
        LC239 solution = new LC239();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{7, 2, 4}, 2)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>(); // 可以使用头尾指针（head，tail）优化双端队列的开销
        int n = nums.length;
        int[] ans = new int[n-k+1];
        for(int i=0; i<n; i++){
            if(i>=k){
                if(deque.getFirst() == i-k){
                    deque.removeFirst();
                }
            }   
            
            while (!deque.isEmpty() && nums[deque.getLast()]<nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if(i>=k-1){
                ans[i-k+1] = nums[deque.getFirst()];
            }
            // deque.forEach(j -> System.out.print(nums[j] + " "));
            System.out.println();
        }

        return ans;
    }
}
