package simple;

public class LC75_sol2 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int[] p = new int[2];
        // 只是把数丢到0序列 1序列 2序列的末尾
        for(int i=0; i<n; i++){
            int x = nums[i];
            nums[i] = 2;
            if(x <= 1){
                nums[p[1]++] = 1;
            }
            if(x == 0){
                nums[p[0]++] = 0;
            }
        }
        
    }
}
