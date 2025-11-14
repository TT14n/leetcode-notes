package dp;
import java.util.ArrayDeque;
import java.util.Deque;

public class LC3578 {
    public static void main(String[] args) {
        LC3578 solution = new LC3578();
        System.out.println(solution.countPartitions(new int[]{9,4,1,3,7}, 4));

    }
    public int countPartitions(int[] nums, int k) {
        int MOD = 10_0000_0000 + 7;
        int[] sum = new int[nums.length+2]; 
        sum[0] = 1;
        int head = -1;
        Deque<Integer> minStack = new ArrayDeque<>();
        Deque<Integer> maxStack = new ArrayDeque<>();
        int f = 0;
        for(int i=0; i<nums.length; i++){
            // 更新单调栈结构
            while(!minStack.isEmpty() && nums[minStack.peek()] >= nums[i]){
                minStack.pop();
            }
            minStack.push(i);

            while(!maxStack.isEmpty() && nums[maxStack.peek()] <= nums[i]){
                maxStack.pop();
            }
            maxStack.push(i);

            // 删除过期值  
            while(!maxStack.isEmpty() && !minStack.isEmpty() && nums[maxStack.getLast()] - nums[minStack.getLast()] > k){
                if(maxStack.getLast() < minStack.getLast()){
                    head = maxStack.pollLast();
                }else{
                    head = minStack.pollLast();
                }
            }

            // sum[i+1] 包括 从 nums[0] ~ nums[i]
            f = (sum[i] - (head==-1 ? 0 : sum[head]) + MOD) % MOD;
            sum[i+1] = (sum[i] + f) % MOD;
        }
        return f;
    }

}
