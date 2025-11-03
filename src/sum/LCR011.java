package sum;

import java.util.HashMap;

public class LCR011 {
    public int findMaxLength(int[] nums) {
        int[] sumArray = new int[nums.length + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        map.put(0, 0);
        for(int i=0; i<nums.length; i++){
            sumArray[i+1] = sumArray[i] + (nums[i]==1 ? 1 : -1);
//            System.out.println(i + " " + sumArray[i+1] + " " + nums[i]);
            if(map.containsKey(sumArray[i+1])){
//                System.out.println(ans + " " + (i + 1 - map.get(sumArray[i + 1])));
                ans = Math.max(ans, i+1-map.get(sumArray[i+1]));
            }else{
                map.put(sumArray[i+1], i+1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LCR011 solution = new LCR011();
        int result = solution.findMaxLength(new int[]{0, 1});
        System.out.println(result);
    }
}

