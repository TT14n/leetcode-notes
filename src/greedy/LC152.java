package greedy;

public class LC152 {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int pre = 0;
        int mul = 1;
        for(int num : nums){
            // 有0的时候，后面的子数组相当于重新开始
            if(num == 0){
                pre = 0;
                mul = 1;
                ans = Math.max(ans, 0);
                continue;
            }

            mul *= num;
            ans = Math.max(mul, ans);
            if(mul < 0 ){
                if(pre == 0){
                    // 记录最小的负数组合
                    pre = mul;
                }else{
                    // 记录正数情况的最大值
                    ans = Math.max(mul / pre, ans);
                }
            }

        }

        return ans;
    }
}
