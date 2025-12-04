package search;

public class LC79 {
    public static void main(String[] args) {
        LC79 solution = new LC79();
        System.out.println(solution.exist(new char[][]{{'a'}},"a"));   
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int[][] visited = new int[n][m];
        char[] chars = word.toCharArray();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == chars[0] && dfs(i, j, n, m, 1, chars, board, visited)){
                    return true;
                } 
            }
        }
        return false;
        
    }

    boolean dfs(int r, int c, int n, int m, int index, char[] chars, char[][] board, int[][] visited){
        if(index == chars.length){
            return true;
        }
        visited[r][c] = 1;
        int[][] direct = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int i=0; i<direct.length; i++){
            int r1 = r + direct[i][0];
            int c1 = c + direct[i][1];
            // 边界判断，是否访问过，是否相等
            if(r1 >= 0 && r1 < n && c1 >= 0 && c1 < m && visited[r1][c1] == 0 && board[r1][c1] == chars[index]){
                if(dfs(r1, c1, n, m, index+1, chars, board, visited)){
                    return true;
                } 
            }
        } 
        visited[r][c] = 0;
        return false;
    }
}
