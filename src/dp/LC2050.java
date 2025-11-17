package dp;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

// 拓扑DP
public class LC2050 {
    public static void main(String[] args) {
        LC2050 solution = new LC2050();
        System.out.println(solution.minimumTime(5, new int[][]{{1,5},{2,5},{3,5},{3,4},{4,5}}, new int[]{1,2,3,4,5}));
    }
    
    public int minimumTime(int n, int[][] relations, int[] time) {
        // Kahn 算法，拓扑排序
        // 计算所有节点的入度
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(); 
        int[] inDegree = new int[n+1];
        for(int[] relation : relations){
            int u = relation[0], v = relation[1];
            inDegree[v]++;
            if(map.containsKey(u)){
                ArrayList<Integer> val = map.get(u);
                val.add(v);   
            }else{
                ArrayList<Integer> val = new ArrayList<Integer>(); 
                map.put(u, val);
                val.add(v);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=1; i<=n; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        } 

        int[] f = new int[n];
        int ans = 0;
        while(!queue.isEmpty()){
            for(int i=0; i<queue.size(); i++){
                int u = queue.poll();
                // 更新当前节点的时间
                f[u-1] += time[u-1];
                ans = Math.max(ans, f[u-1]); 
                ArrayList<Integer> arr =  map.get(u);
                if(arr == null){
                    continue;
                }
                for(int v :arr){
                    inDegree[v]--;
                    f[v-1] = Math.max(f[v-1], f[u-1]); 
                    if(inDegree[v] == 0){
                        queue.add(v);
                    }
                }
            }     
        }

        return ans;
    }
}
