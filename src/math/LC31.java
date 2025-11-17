package math;
public class LC31 {
    public static void main(String[] args) {
        
    }
    public void nextPermutation(int[] nums) {
        // 找到第一个非降序排列的数
        int i;
        for(i=nums.length-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                break;
            }
        }

        // 找到第一个大于 nums[i] 的数
        if(i>=0){
            int j;
            for(j=nums.length-1; j>i; j--){
                if(nums[j] > nums[i]){
                    break;
                }
            }
            // 交换 nums[i] 和 nums[j]
            swap(nums, i, j);
        }
        
        // reverse
        reverse(nums, i+1, nums.length-1);
    }

    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    void reverse(int[] nums, int l, int r){
        while(l < r){
            swap(nums, l++, r--);
        }
    }
}
