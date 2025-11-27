package topo;
import java.util.*;

public class LC210_sol2 {
    private int[] visited;
    private int[] finished;
    private int[] result;
    private int index;
    HashMap<Integer, ArrayList<Integer>> map;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 拓扑排序，通过dfs搜索结果
        map = new HashMap<>();
        for(int i=0; i<numCourses; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] order : prerequisites){
            int u = order[0], v = order[1];
            // 这里是依赖关系，u 要执行，必须 v 先执行
            map.get(u).add(v);
        }

        visited = new int[numCourses];
        result = new int[numCourses];
        finished = new int[numCourses];
        
        
        for(int i=0; i<numCourses; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                dfs(i);
            }
        }

        if(index == numCourses){
            return result;
        }else{
            return new int[0];
        }
        
    }

    // u 表示当前节点
    void dfs(int u){
        // 搜索依赖的节点 v
        int cnt = 0;
        for(int v : map.get(u)){
            if(visited[v] == 0){
                visited[v] = 1;
                dfs(v);
            }

            if(finished[v] == 1){
                cnt++;
            }
        }
        
        if(cnt == map.get(u).size()){
            result[index++] = u;
            finished[u] = 1;
        }
    }

}
