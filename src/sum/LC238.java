package sum;

public class LC238 {
    public int[] productExceptSelf(int[] nums) {
        // 分别计算前缀乘和后缀乘
        int[] lmul = new int[nums.length];
        int[] rmul = new int[nums.length];
        lmul[0] = nums[0];
        rmul[nums.length-1] = nums[nums.length-1];

        for(int i=1; i<nums.length; i++){
            lmul[i] = lmul[i-1] * nums[i];
            int j=nums.length-1-i;
            rmul[j] = rmul[j+1] * nums[j];
        }
        for(int i=0; i<nums.length; i++){
            System.out.print(lmul[i] + " ");
        }
        System.out.println();
        for (int i=0; i<nums.length; i++){
            System.out.print(rmul[i] + " ");
        }
        int[] answer = new int[nums.length];
        for (int i=0; i<nums.length; i++){
            int lpart = (i-1) < 0 ? 1 : lmul[i-1];
            int rpart = (i+1) >= nums.length ? 1 : rmul[i+1];
            answer[i] =  lpart * rpart;
        }
        return answer;
    }


    public static void main(String[] args) {
        LC238 solution = new LC238();
        int[] result = solution.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println();
        for(int num:result){
            System.out.print(num + " ");
        }
    }
}

