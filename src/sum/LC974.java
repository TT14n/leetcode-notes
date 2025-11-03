package sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LC974 {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);
        for (int num : nums) {
            sum = ((sum + num) % k + k) % k; // 防止负数模数取余
            int mod_count = countMap.getOrDefault(sum, 0);
            count += mod_count;
            countMap.put(sum, mod_count + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        LC974 solution = new LC974();
        int result = solution.subarraysDivByK(new int[]{-1,2,9}, 2);
        System.out.println(result);
    }
}

