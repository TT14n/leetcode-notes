package sum;

public class LC209_SlidingWindow {
    public int minSubArrayLen(int target, int[] nums) {
        // 使用滑动窗口
        int left = 0;
        int right = 0;
        int[] sumNums = new int[nums.length+1];
        int ans = nums.length + 1;
        while (right < nums.length){
            sumNums[right+1] = sumNums[right] + nums[right];
//            System.out.println(right + " " + (sumNums[right+1]) + " " + nums[right]);
            while (sumNums[right+1] - sumNums[left] >= target && left <= right){
                ans = Math.min(ans, right-left+1);
                left++;
            }
            right++;
        }
        return ans == nums.length + 1 ? 0 : ans;
    }

    public static void main(String[] args) {
        LC209_SlidingWindow solution = new LC209_SlidingWindow();
        int result = solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(result);
    }
}

