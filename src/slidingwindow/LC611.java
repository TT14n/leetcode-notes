package slidingwindow;

import java.util.Arrays;

public class LC611 {
    public int triangleNumber(int[] nums) {
        // 两边之和大于第3边（最长边）即可
        Arrays.sort(nums);
        int ans = 0;
        // k 枚举最长边
        for(int k=nums.length-1; k>=2; k--){
            int l = 0, r = k-1;
            while(l < r){
                while (l < r && nums[l] + nums[r] <= nums[k]){
                    l++;
                }
                // l 枚举最短边，满足时直接 +(r-l) 即可，因为l后面的边都满足
                ans += r - l;
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LC611 sol = new LC611();
        int[] nums = {2,2,3,4};
        System.out.println(sol.triangleNumber(nums));
    }
}







