package deltaArray;


public class LC2132 {
    public static void main(String[] args) {
        LC2132 solution = new LC2132();
        boolean res = solution.possibleToStamp(new int[][]{{1,0,0,0},{1,0,0,0},{1,0,0,0},{1,0,0,0},{1,0,0,0}}, 4, 3);
        System.out.println(res);
        
    }

    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int m = grid.length;
        int n = grid[0].length;

        // grid 进行二维前缀和，辅助判断可以进行贴邮票的地方
        // 为代码方便 i,j 从 1 开始，区别于 grid 的从 0开始
        int[][] sumGrid = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                sumGrid[i][j] = sumGrid[i-1][j] + sumGrid[i][j-1] - sumGrid[i-1][j-1] + grid[i-1][j-1];
            }
        }

        // 尝试贴邮票，通过二维差分数组，表示是否有邮票贴上
        // 这里数组范围需要再加1，防止越界
        int[][] diffStamp = new int[m+2][n+2];
        for(int i=stampHeight; i<=m; i++){
            for(int j=stampWidth; j<=n; j++){
                // 可以贴的判断是，这个矩阵里没有 x，即 sumGrid 为 0
                if(sumGrid[i][j] 
                - sumGrid[i-stampHeight][j] 
                - sumGrid[i][j-stampWidth] 
                + sumGrid[i-stampHeight][j-stampWidth]  == 0){
                    int r1 = i-stampHeight+1, c1 = j-stampWidth+1;
                    int r2 = i+1, c2 = j+1;
                    diffStamp[r1][c1] += 1;
                    diffStamp[r1][c2] -= 1;
                    diffStamp[r2][c1] -= 1;
                    diffStamp[r2][c2] += 1;
                }
            }
        }

        // 加和差分数组，并逐一判断没有 x 的格子是否被填充
        int[][] sumStamp = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                sumStamp[i][j] = sumStamp[i-1][j] + sumStamp[i][j-1] - sumStamp[i-1][j-1] + diffStamp[i][j]; 
                if(grid[i-1][j-1] == 0 && sumStamp[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

}
