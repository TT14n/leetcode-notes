package math;
public class LC287_sol3 {
    public static void main(String[] args) {
        LC287_sol3 solution = new LC287_sol3();
        System.out.println(solution.findDuplicate(new int[]{1,3,4,2,2}));
        
    }
    public int findDuplicate(int[] nums) {
        // 视作环形链表
        // index 视为 node 当前的位置 [0, n]
        // nums[index] 视为 node 的下一个位置 ([1, n])
        // 因为 nums[index] 有重复值，所以必定存在环形链表

        // Floyd 判圈算法
        // L = b + c (b为相遇位置)
        // a + k1L + b = 2(a+ k2L + b) = 2*step
        // a + b + (2k2-k1)L = 0
        // a = L - b = c
        // step = a + k2L + b 再走 c 步就到达入环的起点
        int slow = 0, fast = 0;
        while(true){
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(slow == fast){
                break;
            }
        }

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
