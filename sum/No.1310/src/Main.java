import java.util.Arrays;
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xorArray = new int[arr.length+1];
        for(int i=0; i<arr.length; i++){
            xorArray[i+1] = arr[i] ^ xorArray[i];
        }
        int[] result = new int[queries.length];
        for (int i=0; i<queries.length; i++){
            int l=queries[i][0], r=queries[i][1];
            result[i] = xorArray[r+1] ^ xorArray[l];
        }
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.xorQueries(new int[]{1, 3, 4, 8}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}});
        for (int num:result){
            System.out.print(num + " ");
        }
    }
}
