package topo;
import java.util.*;

public class LC210_sol1 {
    public static void main(String[] args) {
        
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 拓扑排序，通过入度排序
        
        int[] inDegree = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0; i<numCourses; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] order : prerequisites){
            int u = order[1], v = order[0];
            inDegree[v]++;
            map.get(u).add(v);
        }

        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++){
            if (inDegree[i] == 0) {
                q.addLast(i);
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.removeFirst();
            arr.add(u);
            for(int v : map.get(u)){
                inDegree[v]--;
                if(inDegree[v] == 0){
                    q.addLast(v);
                }
            }
        }

        int[] order = arr.stream().mapToInt(Integer::intValue).toArray();
        return order.length == numCourses ? order : new int[0];
    }
}
