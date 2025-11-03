package sum;

import java.util.HashMap;

public class LCR010 {
    public int subarraySum(int[] nums, int k) {
        int[] sumArray = new int[nums.length + 1];
        int count = 0;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);
        for(int i=0; i<nums.length; i++) {
            sumArray[i+1] = sumArray[i] + nums[i];
            if(countMap.containsKey(sumArray[i+1] - k)) {
                count += countMap.get(sumArray[i+1] - k);
            }
            countMap.put(sumArray[i+1], countMap.getOrDefault(sumArray[i+1], 0)+1);
        }
        return count;

    }
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        Solution s = new LCR010();
        System.out.println(s.subarraySum(nums, k));
    }
}

