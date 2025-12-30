package simple;

public class LC75_sol1 {
    public static void main(String[] args) {
        LC75_sol1 solution = new LC75_sol1();
        int[] nums = new int[]{2,0,2,1,1,0};
        solution.sortColors(nums);
        System.out.println(nums);
    }
    public void sortColors(int[] nums) {
        int r = 0;
        int n = nums.length;
        int[] p = new int[]{-1, -1, -1};
        while (true) {
            while (r+1 < n && nums[r] <= nums[r+1]) {
                System.out.println(r + " " + p[0] + " " + p[1] + " " + p[2]);
                p[nums[r]] = r;
                r++;
            } 
            
            if(r+1 == n){
                break;
            }

            p[nums[r]] = r;
            if(nums[r+1] == 0){
                nums[++p[0]] = 0;
                if(p[1] >= 0){
                    nums[++p[1]] = 1;
                }
                if(p[2] >= 0){
                    nums[++p[2]] = 2;
                }
            }else if(nums[r+1] == 1){
                p[1] = Math.max(p[0], p[1]);
                nums[++p[1]] = 1;
                nums[++p[2]] = 2;
            }
            r++;
        }
        
        
    }
}
