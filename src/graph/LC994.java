package graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class LC994 {
    public class Pair {
        int x, y, minute;
        public Pair(int x, int y, int minute){
            this.x = x;
            this.y = y;
            this.minute = minute;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new ArrayDeque<>();
        // 初始化
        int cnt = 0;
        int n = grid.length, m = grid[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    grid[i][j] = 0;
                }else if(grid[i][j] == 1){
                    cnt++;
                }
            }
        }

        Pair now;
        int ans = 0;
        int[][] direct = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (!q.isEmpty()) {
            now = q.poll();
            int x = now.x;
            int y = now.y;
            int minute = now.minute;
            ans = Math.max(ans, minute);
            for(int i=0; i<4; i++){
                int xx = x+direct[i][0];
                int yy = y+direct[i][1];
                if(xx>=0 && xx<n && yy>=0 && yy<m && grid[xx][yy] == 1){
                    q.add(new Pair(xx, yy, minute+1));
                    grid[xx][yy] = 0;
                    cnt--;
                }
            }
        }

        if(cnt > 0){
            ans = -1;
        }

        return ans;

    }
}
