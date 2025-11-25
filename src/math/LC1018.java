package math;
import java.util.*;

public class LC1018 {
    public static void main(String[] args) {
        LC1018 solution = new LC1018();
        System.out.println(solution.prefixesDivBy5(new int[]{1,0,1}));
    }
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> list = new ArrayList<>(nums.length);
        int val = 0;
        for(int num : nums){
            val = val << 1 | num;
            val %= 5;
            list.add(val == 0);
        }
        return list;
    }
}
