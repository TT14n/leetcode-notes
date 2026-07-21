package simple;

public class LC74 {
    public static void main(String[] args) {
        
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m =  matrix[0].length;
        int r, c;
        if(matrix[0][0] > target) return false;

        for(r = 0; r < n-1; r++){
            if(matrix[r+1][0] > target){
                break;
            }
        }


        for(c = 0; c < m-1; c++){
            if(matrix[r][c] == target){
                break;
            }
        }

        return matrix[r][c] == target;
    }
}
