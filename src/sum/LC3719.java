package sum;
import java.util.HashMap;

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        // n^2
        int ans = 0;
        for(int l=0; l<n; l++){ // 枚举左右端点
            HashMap<Integer, Integer> map = new HashMap<>();
            int oddCnt = 0, evenCnt = 0;
            for(int r=l; r<n; r++){
                int key = nums[r];
                if(map.containsKey(key)){
                    map.put(key, map.get(key) + 1);
                }else{
                    map.put(key, 1);
                    if(key%2==1){
                        oddCnt += 1;
                    }else{
                        evenCnt += 1;
                    }
                }
                
                int len = r-l+1;
                if(oddCnt == evenCnt && len > ans){
                    ans = len;
                }
            }
        }

        return ans;
    }
}