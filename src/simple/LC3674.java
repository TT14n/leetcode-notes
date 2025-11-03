package simple;

public class LC3674 {
    public int minOperations(int[] nums) {
        int i=1;
        while(i<nums.length && nums[i]==nums[i-1]){
            i++;
        }
        if (i==nums.length){
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        LC3674 sol = new LC3674();
        int[] nums = {1, 2};
        System.out.println(sol.minOperations(nums));
    }
}

