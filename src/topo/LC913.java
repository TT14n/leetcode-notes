package topo;
import java.util.*;

public class LC913 {
    private int HOLE = 0;
    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        // 第一个维度表示鼠的位置
        // 第二个维度表示猫的位置
        // 第三个维度[0, 1]表示分别表示谁先移动，0表示鼠先移动，1表示猫先移动
        // 0 表示未确定或者平局，1表示鼠获胜，2表示猫获胜
        int[][][] winner = new int[n][n][2];
        // 从终点开始倒推，能否得到一个鼠在节点 1，猫在节点 2，当前轮到鼠移动的状态？即 winner[1][2][0]
        // 倒推的情况：
        // 1. winner[i][j][1] = 1，则上一个状态 winner[i'][j][0] = 1（鼠从 i 移动到 i'）
        // 2. winner[i][j][0] = 2，则上一个状态 winner[i][j'][1] = 2（猫从 j 移动到 j'）
        // 3. 如果上一个状态 winner[i'][j][0]，鼠不管怎么走都是猫赢，则 winner[i'][j][0] = 2;
        // 4. 如果上一个状态 winner[i][j'][1]，猫不管怎么走都是鼠赢，则 winner[i][j'][1] = 1;

        // 使用拓扑排序处理情况 3 和情况 4
        // deg[i][j][0] 表示鼠鼠的出度，即可以走的路径
        // deg[i][j][1] 表示猫猫的出度
        int[][][] deg = new int[n][n][2];
        for(int i=0; i<n; i++){ // 鼠鼠的位置
            for(int j=0; j<n; j++){ // 猫猫的位置
                deg[i][j][0] = graph[i].length;
                deg[i][j][1] = graph[j].length;
            }
            // 对于猫来说，所有连到洞的边都不能走
            for(int j : graph[HOLE]){
                deg[i][j][1]--;
            }
        }


        // 使用队列
        Deque<int[]> q = new ArrayDeque<>();
        for(int i=1; i<n; i++){
            winner[HOLE][i][1] = 1; // 鼠鼠达到洞中（同时轮到猫猫移动），此时鼠鼠获胜
            winner[i][i][0] = winner[i][i][1] = 2; // 猫猫和鼠鼠出现在同一个节点，无论轮到谁移动，都是猫猫获胜
            q.offer(new int[]{HOLE, i, 1}); // 从终点开始倒推
            q.offer(new int[]{i, i, 0});
            q.offer(new int[]{i, i, 1});
        }


        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int mouse = cur[0], cat = cur[1], turn = cur[2];
            int win = winner[mouse][cat][turn]; // 最终谁赢了
            for(int[] pre : getPreStates(mouse, cat, turn, graph, winner)){
                int preMouse = pre[0], preCat = pre[1], preTurn = turn^1;
                // 情况 1 和情况 2 用 preTurn == win-1 表示
                // 情况 3 和情况 4 用 --deg[preMouse][preCat][preTurn] == 0 表示
                if(preTurn == win-1 || --deg[preMouse][preCat][preTurn] == 0){
                    winner[preMouse][preCat][preTurn] = win;
                    q.offer(new int[] {preMouse, preCat, preTurn}); // 继续倒推
                }
           
            }

        }


        return 0;        

    }

    // 获取 (mouse, cat, turn) 的上个状态（值尚未确定）
    private List<int[]> getPreStates(int mouse, int cat, int turn, int[][] graph, int [][][] winner){
        List<int[]> preStates = new ArrayList<>();
        if(turn == 0){ // 当前轮到鼠鼠移动，则上一轮是猫猫移动
            for(int preCat : graph[cat]){ // 上一轮猫的位置
                if(preCat != HOLE && winner[mouse][preCat][1] == 0){ // 猫无法移动到洞中，同时不要搜索已经搜索过的状态
                    preStates.add(new int[]{mouse, preCat});
                }
            }
        }else{ // 当前是猫猫移动，则上一轮是鼠鼠移动
            for(int preMouse : graph[mouse]){ // 上一轮鼠鼠的位置
                if (winner[preMouse][cat][0] == 0) {
                    preStates.add(new int[]{preMouse, cat});
                }
            }
        }

        return preStates;
    }
}
