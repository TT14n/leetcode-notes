package sum;

public class LC304 {
    static class NumMatrix {
    private final int[][] matrixSum;
    public NumMatrix(int[][] matrix) {
        int[][] matrixSum = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                matrixSum[i][j] = matrix[i][j];
                if(i-1>=0) matrixSum[i][j] += matrixSum[i-1][j];
                if(j-1>=0) matrixSum[i][j] += matrixSum[i][j-1];
                if(i-1>=0 && j-1>=0) matrixSum[i][j] -= matrixSum[i-1][j-1];
            }
        }
        this.matrixSum = matrixSum;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrixSum[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = matrixSum[row2][col2];
        if(row1-1>=0) result -= matrixSum[row1-1][col2];
        if(col1-1>=0) result -= matrixSum[row2][col1-1];
        if(row1-1>=0 && col1-1>=0) result += matrixSum[row1-1][col1-1];
        return result;
    }

    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix obj = new NumMatrix(matrix);
        int result1 = obj.sumRegion(2,1,4,3);
        int result2 = obj.sumRegion(1,1,2,2);
        int result3 = obj.sumRegion(1,2,2,4);
        System.out.println(result1 + " " + result2 + " " + result3);

    }
}

