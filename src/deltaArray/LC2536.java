package deltaArray;
public class LC2536 {
    public static void main(String[] args) {
        LC2536 solution = new LC2536();
        // int[][] res = solution.rangeAddQueries(4, new int[][]{{0,0,3,3}});
        int[][] res = solution.rangeAddQueries(3, new int[][]{{1,1,2,2}, {0,0,1,1}});
        for(int i=0; i<res.length; i++){
            for(int j=0; j<res[0].length; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diffMat = new int[n+1][n+1];
        for(int[] query : queries){
            int row1 = query[0];
            int col1 = query[1];
            int row2 = query[2];
            int col2 = query[3];
            
            diffMat[row1][col1] += 1;
            diffMat[row2+1][col1] -= 1;
            diffMat[row1][col2+1] -= 1;
            diffMat[row2+1][col2+1] += 1;
        }            

        int[][] res = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                res[i][j] = diffMat[i][j];
                if(i>0){
                    res[i][j] += res[i-1][j];
                }
                if(j>0){
                    res[i][j] += res[i][j-1];
                }
                if(i>0 && j>0){
                    res[i][j] -= res[i-1][j-1];
                }
            }
        }
        return res;
    }
}
