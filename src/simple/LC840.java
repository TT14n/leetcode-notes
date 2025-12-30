package simple;

public class LC840 {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i=1; i<n-1; i++){
            for(int j=1; j<m-1; j++){
                if(grid[i][j] == 5){
                    ans += check(i, j, grid) ? 1 : 0;
                }
            }
        }
        return ans;
    }

    boolean check(int row, int col, int[][] grid){
        int[] record = new int[10];
        // 判断是否重复，是否满足 1~9
        for(int i=row-1; i<=row+1; i++){
            for(int j=col-1; j<=col+1; j++){
                int num = grid[i][j];
                if(num == 0 || num > 9){
                    return false;
                }
                if(record[num] == 1){
                    return false;
                }
                record[num] = 1;
            }
        }

        // 判断row相加为15
        for(int i=row-1; i<=row+1; i++){
            int row_sum = 0;
            for(int j=col-1; j<=col+1; j++){
                row_sum += grid[i][j]; 
            }
            if(row_sum != 15){
                return false;
            }
        }


        // 判断col相加为15
        for(int j=col-1; j<=col+1; j++){
            int col_sum = 0;
            for(int i=row-1; i<=row+1; i++){
                col_sum += grid[i][j]; 
            }
            if(col_sum != 15){
                return false;
            }
        }

        // 判断斜线
        if(grid[row-1][col-1] + grid[row+1][col+1] != 10){
            return false;
        }

        if(grid[row-1][col+1] + grid[row+1][col-1] != 10){
            return false;
        }

        return true;
    }
}
