package math;
import java.util.HashMap;

public class LC2154_sol2 {
    public static void main(String[] args) {
        LC2154_sol2 solution = new LC2154_sol2();
        System.out.println(solution.findFinalValue(new int[]{5, 3, 6, 1, 12}, 3));
    }   
    public int findFinalValue(int[] nums, int original) {
        int bits = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] % original == 0) {
                nums[i] /= original;
                if((nums[i] & -nums[i]) == nums[i]){
                    bits |= nums[i];
                }
            }
        }

        // 找到 bits 各位置中第一个 0 的位置
        // 反向思考：找到第一个 1 的位置我是会的 x & (-x)
        // 那么第一个 0 的位置就是 ~x & -(~x)
        
        return original*(~bits & -(~bits));
    }
}
