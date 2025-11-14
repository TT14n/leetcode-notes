package deltaArray;
public class LC3489 {
    public static void main(String[] args) {
        LC3489 solution = new LC3489();
        System.out.println(solution.minZeroArray(new int[]{7,6,8}, new int[][]{{0,0,2},{0,1,5},{2,2,5},{0,2,4}}));
    }

    boolean check(int[] nums, int[][] queries, int k){
        // 二分答案 + 差分数组
        // 差分数组只需要记录区间改动的值即可
        int[] diffArray = new int[nums.length];

        for (int i = 0; i < k; i++) {
            int[] query = queries[i];
            int l = query[0], r = query[1]+1, val=query[2];
            diffArray[l] -= val;
            if(r < nums.length){
                diffArray[r] += val;
            }  
        }
        
        // 计算结果
        boolean result = true;
        // System.out.println(k);
        int diff = 0;
        for(int i=0; i<nums.length; i++){
            diff += diffArray[i];
            // System.out.println(i + " " + diffArray[i] + " " +  diff + " " + nums[i]);
            if(nums[i] + diff > 0){
                result = false;
                break;
            }
        }

        return result;
    }
    
    public int minZeroArray(int[] nums, int[][] queries) {
        // 差分 + 二分答案
        int l = 0, r = queries.length;
        while(l < r){
            int mid = (l+r)/2;
            if(check(nums, queries, mid)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        if(check(nums, queries, l)){
            return l;
        }else{
            return -1;
        }
    }
}
