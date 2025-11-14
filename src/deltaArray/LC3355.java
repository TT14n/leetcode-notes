package deltaArray;
public class LC3355 {
    
    public static void main(String[] args) {
        LC3355 solution = new LC3355();
        System.out.println(solution.isZeroArray(new int[]{1,0,1}, new int[][]{{0,2}}));
    }

    
    public boolean isZeroArray(int[] nums, int[][] queries) {
        // 差分数组：差分数组对于区间修改非常有用
        int[] diffArray = new int[nums.length];
        diffArray[0] = nums[0];

        // 初始化
        for(int i=1; i<nums.length; i++){
            diffArray[i] = nums[i] - nums[i-1]; 
        }

        // query 选中
        // [1, 3, 2] -> diffArray[1] -= 2, diffArray[4] += 2;
        for(int[] query: queries){
            int l = query[0], r = query[1]+1;
            diffArray[l] -= 1;
            if(r < nums.length){
                diffArray[r] += 1;
            }
        }

        // 计算结果
        boolean result = true;
        int num = 0;
        for(int i=0; i<nums.length; i++){
            num += diffArray[i];
            // System.out.println(i + " " + diffArray[i] + " " +  num );
            if(num > 0){
                result = false;
                break;
            }
        }
        return result;
    }
}
