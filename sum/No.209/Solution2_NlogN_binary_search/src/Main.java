class Solution {
    private boolean check(int len, int target, int[] sumNums){
        for(int r=len; r<sumNums.length; r++){
            if(sumNums[r] - sumNums[r-len] >= target){
                return true;
            }
        }
        return false;
    }
    public int minSubArrayLen(int target, int[] nums) {
        // 使用二分查找窗口长度
        int right_len = nums.length;
        int left_len = 0;
        int ans = nums.length + 1;
        int[] sumNums = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++){
            sumNums[i+1] = sumNums[i] + nums[i];
        }
        while (left_len <= right_len){
            int mid = (left_len + right_len) / 2;
//            System.out.println(mid + " " + check(mid, target, sumNums));
            if(check(mid, target, sumNums)){
                ans = Math.min(ans, mid);
                right_len = mid - 1;
            }else{
                left_len = mid + 1;
            }
        }
        return ans == nums.length + 1 ? 0 : ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(result);
    }
}