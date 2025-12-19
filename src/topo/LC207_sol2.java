package topo;

import java.util.ArrayList;

public class LC207_sol2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 判断是否有环
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            arr.add(new ArrayList<>());
        }
        // 有向边 b->a
        for(int[] require : prerequisites){
            int a = require[0], b = require[1];
            arr.get(b).add(a);
        }

        int[] colors = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            if(colors[i] == 0 && dfs(i, arr, colors)){
                return false; // 有环
            }
        }

        return true;
    }

    // 返回 true 表示找到了环
    private boolean dfs(int b, ArrayList<ArrayList<Integer>> g, int[] colors){
        // 正在搜索
        colors[b] = 1; 

        // 继续搜索
        for(int a : g.get(b)){
            if(colors[a] == 1 || (colors[a] == 0 && dfs(a, g, colors))){
                return true;
            }
        }

        colors[b] = 2;

        return false;
    }

}
