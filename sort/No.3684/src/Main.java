import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        Arrays.sort(nums);
        ArrayList<Integer> array = new ArrayList<>();
        int j = nums.length - 1;
        int count = 0;
        for(int i=0; i<k; i++){
            while(j-1>=0 && nums[j] == nums[j-1]) j--;
            array.add(nums[j]);
            j--;
            count++;
            if(j<0) break;
        }
        int[] result = new int[count];
        for(int i=0; i<count; i++){
            result[i] = array.get(i);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}