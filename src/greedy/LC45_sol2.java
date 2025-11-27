package greedy;
public class LC45_sol2 {
    public static void main(String[] args) {
        LC45_sol1 solution = new LC45_sol1();
        System.out.println(solution.jump(new int[]{1,2,1,1,1}));
    }

    public int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }

        int s = 0;
        int n = nums.length;
        int ans = 1;
        while (s + nums[s] < n-1) {
            // System.out.println("目前在的地方 " + s + ", 下一步能调多远 " + nums[s]);
            int nextJump = s+1;
            for(int i=s+1; i<=s+nums[s]; i++){ // 每次都选下次能跳的最远的地方去跳
                if(i + nums[i] > nextJump + nums[nextJump]){
                    nextJump = i;
                }
            }
            s = nextJump;
            
            ans ++;
        }
        return ans;

    }
}
