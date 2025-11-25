package math;
import java.util.HashMap;

public class LC2154_sol1 {
    public static void main(String[] args) {
        LC2154_sol1 solution = new LC2154_sol1();
        System.out.println(solution.findFinalValue(new int[]{5, 3, 6, 1, 12}, 3));
    }   
    public int findFinalValue(int[] nums, int original) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], true);
        }   
        while (map.containsKey(original)) {
            original = original*2;
        }
        return original;
    }
}
