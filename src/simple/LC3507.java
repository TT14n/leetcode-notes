package simple;
import java.util.Arrays;

public class LC3507 {
    private int[] addMinnumPair(int [] nums){
        int minPairNum = nums[0] + nums[1];
        int minPairPos = 0;
        for(int i=1; i<nums.length-1; i++){
            if(nums[i] + nums[i+1] < minPairNum){
                minPairPos = i;
                minPairNum = nums[i] + nums[i+1];
            }
        }
        // System.out.println(minPairPos + " " + minPairNum);
        nums[minPairPos] += nums[minPairPos+1];
        for(int i=minPairPos+1; i<nums.length-1; i++){
            nums[i] = nums[i+1];
        }
        return Arrays.copyOfRange(nums, 0, nums.length-1);
    }

    private boolean checkNonDcreasing(int [] nums){
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]) return false;
        }
        return true;
    }
    
    public int minimumPairRemoval(int[] nums) {
        int result = 0;
        while(!checkNonDcreasing(nums)){
            result++;
            nums = addMinnumPair(nums);
            // for(int num : nums){
            //     System.out.print(num + " " );
            // }
            // System.out.println();
        }
        return result;
    }
    public static void main(String[] args) {
        LC3507 solution = new LC3507();
        System.out.println(solution.minimumPairRemoval(new int[]{1000,999,998,997,996,995,994,993,992,991,990,989,988,987,986,985,984,983,982,981,980,979,978,977,976,975,974,973,972,971,970,969,968,967,966,965,964,963,962,961,960,959,958,957,956,955,954,953,952,951}));
    }
}
