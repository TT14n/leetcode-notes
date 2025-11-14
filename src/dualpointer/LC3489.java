package dualpointer;

public class LC3489 {
    public static void main(String[] args) {
        LC3489 solution = new LC3489();
        System.out.println(solution.minZeroArray(new int[]{0,10}, new int[][]{{0,1,2},{0,0,2},{0,1,2},{1,1,4},{0,1,3},{1,1,4},{0,1,2},{0,1,2},{0,1,2},{0,0,2},{1,1,2},{0,0,2},{0,0,3},{1,1,3},{0,0,5}}));
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        // 双指针
        int numPointer = 0, queryPointer = 0;
        int delta = 0;
        int[] deltaArray = new int[nums.length];
        while (numPointer < nums.length && queryPointer < queries.length) {
            // System.out.println(numPointer + " " +  queryPointer);
            while(nums[numPointer] + delta > 0){
                int l = queries[queryPointer][0];
                int r = queries[queryPointer][1];
                int val = queries[queryPointer][2];
                if(r+1 < nums.length){
                    deltaArray[r+1] += val;
                }
                if(l <= numPointer && numPointer <= r){
                    delta -= val;
                }else{
                    deltaArray[l] -= val;
                }
                queryPointer++;
                if(queryPointer == queries.length){
                    break;
                }

                // System.out.println(numPointer + " " + queryPointer + " " + delta + " " + deltaArray[numPointer] + " ");
            }

            while(nums[numPointer] + delta <= 0){
                numPointer++;
                if(numPointer == nums.length){
                    break;
                }
                delta += deltaArray[numPointer];
            }
        }
        if(numPointer == nums.length){
            return queryPointer;
        }else{
            return -1 ;
        }
    }

}
