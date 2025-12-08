package dp;

public class LC53 {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE/2;
        int sum = 0;
        for(int num : nums){
            if(sum < 0){
                sum = 0;
            }
            sum += num;
            ans = Math.max(ans, sum);
        }   

        return ans;
    }

}
