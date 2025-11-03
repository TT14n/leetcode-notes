package sum;

public class LC1862 {
    public int sumOfFlooredPairs(int[] nums) {
        int mod = 1_000_000_000 + 7;
        int maxNum = 0; // maxNum <= 10^5
        for(int i=0; i<nums.length; i++){
            maxNum = Math.max(maxNum, nums[i]);
        }

        // 对于每个数字i，计算 floor(j/i) 的和
        // 可以转化为求解 i*d <= j < i*(d+1) - 1 的 j 的个数
        // 使用前缀和简化计算
        long[] count = new long[maxNum+1]; // 统计数组中每个数字出现的次数
        for(int i=0; i<nums.length; i++){
            count[nums[i]]++;
        }

        long[] preSum = new long[maxNum+1];
        for(int i=1; i<=maxNum; i++){
            preSum[i] = (preSum[i-1] + count[i]) % mod;
        }

        long result = 0;
        for (int i=1; i<=maxNum; i++){
            if(count[i] == 0) continue; // 剪枝
            for (int d=1; d<=maxNum/i; d++){
                // d*i <= j <= (d+1)*i-1
                long sum = (preSum[Math.min((d+1)*i - 1, maxNum)] - preSum[i*d-1] + mod) % mod;
                result = (result + ((count[i]*d%mod)*sum%mod)) % mod;
            }
        }
        return (int)result;
    }
    public static void main(String[] args) {
        LC1862 sol = new LC1862();
        int[] nums = {2, 5, 9};
        System.out.println(sol.sumOfFlooredPairs(nums));
    }
}

