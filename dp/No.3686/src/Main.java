class Solution {
    public int countStableSubsequences(int[] nums) {
        // 维护奇偶连续性为1和2的序列的个数
        long[][] counts = new long[2][2];
        int mod = 1_000_000_007;
        // 记录最后一个奇数和最后一个偶数
        for(int i=0; i<nums.length; i++){
            // 判断奇偶性
            int x = nums[i] % 2; // 0 偶，1 奇
            // 相同奇偶性，1位连续追加，2位连续累积
            counts[x][1] = (counts[x][0] + counts[x][1]) % mod;
            // 奇偶性不同，直接追加，同时累积相同奇偶性的1位数据，已经在空集上+1
            counts[x][0] = (counts[x][0] + counts[x^1][0] + counts[x^1][1] + 1) % mod;
        }
        long result = counts[0][0] + counts[1][0] + counts[0][1] + counts[1][1];
        return (int)(result%mod);
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2,3,4,2};
        System.out.println(sol.countStableSubsequences(nums));
    }
}