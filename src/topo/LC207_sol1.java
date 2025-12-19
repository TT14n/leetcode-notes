package topo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LC207_sol1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // topo 排序
        int[] deg = new int[numCourses]; // 入度
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            arr.add(new ArrayList<>());
        }
        for(int[] require : prerequisites){
            int a = require[0], b = require[1];
            deg[a]++;
            arr.get(b).add(a);
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++){
            if(deg[i] == 0){
                q.add(i);
            }
        }

        int cnt = numCourses - q.size();
        while (!q.isEmpty()) {
            int b = q.poll();
            for(int a : arr.get(b)){
                deg[a]--;
                if(deg[a] == 0){
                    q.add(a);
                    cnt--;
                }
            }
        }

        if(cnt == 0){
            return true;
        }
        return false;
        
    }
}
