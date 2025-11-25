package math;
public class LC287_sol2 {
    public static void main(String[] args) {
        LC287_sol2 solution = new LC287_sol2();
        System.out.println(solution.findDuplicate(new int[]{1,3,4,2,2}));
        
    }
    public int findDuplicate(int[] nums) {
        // 要确定重复的数字，可以通过确定这个数字各个位的数字判断
        // 数组长度为 n + 1，设在某一位i上， [1, n] 的加和结果为 yi
        // 则当 xi>yi 时，重复的数在这一位为 1
        int n = nums.length - 1;
        int maxBits = 0;
        while(n > (1 << maxBits)){
            maxBits++;
        } 

        // bit 的长度为 log(n)
        // 总体复杂度为 nlog(n)
        int ans = 0;
        for(int bit=0; bit<=maxBits; bit++){
            int x = 0, y = 0;
            for(int i=0; i<=n; i++){
                x += nums[i] & (1 << bit);   
                y += i & (1 << bit);
            }
            if(x > y){
                ans |= 1<<bit;
            }
        }
        return ans;
    }
}
