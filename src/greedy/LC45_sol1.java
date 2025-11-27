package greedy;
public class LC45_sol1 {
    public static void main(String[] args) {
        LC45_sol1 solution = new LC45_sol1();
        System.out.println(solution.jump(new int[]{1,2,1,1,1}));
    }

    public int jump(int[] nums) {
        // 视作过桥
        int curRight = 0;
        int nextRight = 0;
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            if(i > curRight){
                ans++;
                curRight = nextRight;
            }
            nextRight = Math.max(nextRight, i+nums[i]);
        }
        return ans;
    }
}
