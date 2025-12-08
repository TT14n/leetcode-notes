package search;

public class LC200 {
    int n, m;
    int[][] directions = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        int ans = 0;
        n = grid.length;
        m = grid[0].length;
        int[][] visited = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    ans++;
                    dfs(grid, i, j, visited);
                }
            }
        }    
        return ans;
    }
    void dfs(char[][] grid, int row, int col, int[][] visited){
        visited[row][col] = 1;
        for(int i=0; i<4; i++){
            int nrow = row + directions[i][0];
            int ncol = col + directions[i][1];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol] == '1' && visited[nrow][ncol] == 0){
                dfs(grid, nrow, ncol, visited);
            }
        }
    }

}
