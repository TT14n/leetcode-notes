package simple;

public class LC73 {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        boolean firstRowHasZero = false;
        for(int j=0; j<m; j++){
            if(matrix[0][j] == 0){
                firstRowHasZero = true;
                break;
            }
        }

        // 用第一行和第一列存储 0
        for(int i=1; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }    

        // 置 0
        for(int i=1; i<n; i++){
            for(int j=m-1; j>=0; j--){
                if(matrix[i][0] == 0 ||  matrix[0][j] == 0){
                    matrix[i][j] = 0; 
                }
            }
        }

        // 第一行置 0 
        if(firstRowHasZero){
            for(int j=0; j<m; j++){
                matrix[0][j] = 0;
            }
        }
    }
}
