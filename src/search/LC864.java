package search;
import java.util.LinkedList;
import java.util.Queue;

public class LC864 {
    private String keyStr = "abcdef";
    private String lockStr = "ABCDEF";
    private class State{
        int row, col, step, keysCnt;
        int[] keys;

        State(int row, int col, int step, int keysCnt){
            this.row = row;
            this.col = col;
            this.step = step;
            this.keysCnt = keysCnt;
            this.keys = new int[6];
        }

        State(int row, int col, int step, int keysCnt, int[] keys){
            this.row = row;
            this.col = col;
            this.step = step;
            this.keysCnt = keysCnt;
            this.keys = keys;
        }

        int getKeysState(){
            int keyState = 0;
            for(int i=0; i<6; i++){
                keyState |= keys[i] << i;
            }
            return keyState;
        }
        
    }

    public int shortestPathAllKeys(String[] grid) {
        // 有条件的可回头 bfs
        Queue<State> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length();

        // 处理 grid 以及 visited 的初始值
        int totKeys = 0;
        // 状态压缩
        int[][][] visited = new int[n][m][64];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = grid[i].charAt(j);
                if(ch == '@'){
                    // 添加初始节点
                    queue.add(new State(i, j, 0, 0));
                    visited[i][j][0] = 0;
                }else if(keyStr.indexOf(ch) != -1){
                    totKeys++;
                }
            }
        }
        // System.out.println(totKeys);
        // 开始 bfs
        int[][] directions = new int[][]{{0,-1}, {0, 1}, {-1, 0}, {1, 0}};
        int result = -1;
        while(!queue.isEmpty()){
            State nowState = queue.poll();
            int row = nowState.row;
            int col = nowState.col;
            int step = nowState.step;
            int keysCnt = nowState.keysCnt;
            int[] keys = nowState.keys;
            // System.out.println(row + " " + col + " " + step + " " + keysCnt + " " + keys[0] + ":" + keys[1] + ":" + keys[2] + ":" + keys[3] + ":" + keys[4] + ":" + keys[5]);
            
            // 处理当前状态
            char ch = grid[row].charAt(col);
            int key = keyStr.indexOf(ch);
            if (key != -1 && keys[key] != 1) {
                keys[key] = 1;
                keysCnt++;
                if(keysCnt == totKeys){
                    result = step;
                    break;
                }
            }

            // 下一步
            int keyState = nowState.getKeysState();
            for(int i=0; i<4; i++){
                int nextRow = row + directions[i][0];
                int nextCol = col + directions[i][1];
                if(nextRow >= n || nextRow < 0 || nextCol >= m || nextCol < 0){
                    continue;
                }                
                ch = grid[nextRow].charAt(nextCol);
                // 墙
                if(ch == '#'){
                    continue;
                }
                // 锁
                int lock = lockStr.indexOf(ch);
                if(lock != -1 && keys[lock] != 1){
                    continue;
                }
                if(visited[nextRow][nextCol][keyState] < 1){
                    visited[nextRow][nextCol][keyState]++;
                    queue.add(new State(nextRow, nextCol, step+1, keysCnt, keys.clone()));
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        LC864 solution = new LC864();
        System.out.println(solution.shortestPathAllKeys(new String[]{"@...a",".###A","b.BCc"}));
    }

    
}
