package sum;
public class LC3381 {
    public static void main(String[] args) {
        // k 长度
        LC3381 solution = new LC3381();
        System.out.println(solution.maxSubarraySum(new int[]{-1,-2,-3,-4,-5}, 4));
    }
    public long maxSubarraySum(int[] nums, int k) {
        // 子数组 ==> 数组中连续的 非空 元素序列。
        // 连续意味着可以使用前缀和
        // 但是需要确定起始点(0, k-1)，后续可以按照求解最大连续子序列求解（k个数字视作一个元素）
        long[] sum = new long[nums.length + 1];
        for(int i=1; i<=nums.length; i++){
            sum[i] += sum[i-1] + nums[i-1];
        }

        long ans = Long.MIN_VALUE / 2;
        for(int i=0; i<k; i++){
            long acc = 0;
            for(int j=i+k; j<=nums.length; j+=k){
                long num = sum[j] - sum[j-k];
                // System.out.println("[" + (j-k) + "," + (j) + "] " + num);
                if(acc < 0){
                    acc = num;
                }else{
                    acc += num;
                }

                if(acc > ans){
                    ans = acc;
                }
            }
        }

        return ans;
    }
}
