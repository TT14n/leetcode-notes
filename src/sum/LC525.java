package sum;
import java.util.HashMap;

public class LC525 {
    public static void main(String[] args) {
        LC525 solution = new LC525();
        System.out.println(solution.findMaxLength(new int[]{0,1,0}));
        
    }
    public int findMaxLength(int[] nums) {
        // 因为时考虑数量，所以通过 +1，-1，来考虑不同的子数组状态
        // 存储第一次前缀和出现的位置
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int state = 0;
        map.put(0, -1);
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                state--;
            }else{
                state++;
            }
            if(map.containsKey(state)){
                ans = Math.max(ans, i-map.get(state));
            }else{
                map.put(state, i);
            }
        }

        return ans;

    }
}
