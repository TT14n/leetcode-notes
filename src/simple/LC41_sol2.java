package simple;
public class LC41_sol2 {
    public int firstMissingPositive(int[] nums) {
        int maxNum = nums.length;
        for(int i=0; i<maxNum; i++){
            while (true) {
                if(nums[i] <= 0 || nums[i] > maxNum || nums[i] == nums[nums[i]-1]){
                    break;
                }
                int tmp;
                tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        
        }

        int i;
        for(i=0; i<maxNum; i++){
            if(nums[i] != i+1){
                break;
            }
        }
        // System.out.println(Arrays.toString(nums));

        return i+1;

        
    }
}                                                                                                                                                               