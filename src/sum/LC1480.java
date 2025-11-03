package sum;

public class LC1480 {
    public int[] runningSum(int[] nums) {
        int [] sumArray = new int[nums.length];
        sumArray[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            sumArray[i] = nums[i] + sumArray[i-1];
        }
        return sumArray;
    }

    public static void main(String[] args) {
        LC1480 solution = new LC1480();
        int[] nums = new int[]{1, 2, 3, 4};
        int[] result = solution.runningSum(nums);  // 调用函数进行测试
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

