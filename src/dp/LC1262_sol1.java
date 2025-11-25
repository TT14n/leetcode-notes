package dp;
public class LC1262_sol1 {
    public static void main(String[] args) {
        LC1262_sol1 solution = new LC1262_sol1();
        System.out.println(solution.maxSumDivThree(new int[]{3,6,5,1,8}));   
    }
    public int maxSumDivThree(int[] nums) {
        int[] f = new int[3];
        f[1] = Integer.MIN_VALUE;
        f[2] = Integer.MIN_VALUE;

        for(int num : nums){
            int mod = num % 3;
            if(mod == 0){
                f[0] += num;
                f[1] += num;
                f[2] += num;
            }else{
                int[] tmp = new int[3];
                if(mod == 1){
                    tmp[0] = Math.max(f[0], f[2]+num);
                    tmp[1] = Math.max(f[1], f[0]+num);
                    tmp[2] = Math.max(f[2], f[1]+num);
                }else{
                    tmp[0] = Math.max(f[0], f[1]+num);
                    tmp[1] = Math.max(f[1], f[2]+num);
                    tmp[2] = Math.max(f[2], f[0]+num);
                }
                f[0] = tmp[0];
                f[1] = tmp[1];
                f[2] = tmp[2];
            }
        }

        return f[0];
    }
}
