package greedy;

import java.util.HashMap;

public class LC169 {
    public int majorityElement(int[] nums) {
        int cnt = 1;
        int preI = 0;
        for(int i=1; i<nums.length; i++){
            // 相同，累积计数
            if(nums[i] == nums[preI]){
                cnt++;
            // 不同，cnt --，如果 cnt = 0，则更换数字
            }else if(cnt > 0){
                cnt--;
            }else{
                preI = i;
                cnt = 1;
            }
        }
        return nums[preI];
    }
}
