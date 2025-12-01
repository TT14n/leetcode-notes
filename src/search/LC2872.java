package search;
import java.util.ArrayList;

public class LC2872 {
    public static void main(String[] args) {
        LC2872 solution = new LC2872();
        System.out.println(solution.maxKDivisibleComponents(5, new int[][]{{0,2},{1,2},{1,3},{2,4}}, new int[]{1,8,1,4,4}, 6));
    }
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        // 以 0 为 root 节点
        // 当子节点不为连通块时，尝试连接边
        int[] visited = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            values[i] %= k;
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] res = merge(0, adj, values, k, visited);
        return res[1];

    }

    // 需要知道是否需要连接边，以及有多少连通块
    int[] merge(int u, ArrayList<ArrayList<Integer>> adj, int[] values, int k, int[] visited){
        visited[u] = 1;
        int[] res = new int[2];
        int cnt = 0;
        for(int v : adj.get(u)){
            if(visited[v] == 1){
                continue;
            }
            int[] child  = merge(v, adj, values, k, visited);
            if(child[0] == 1){ // 需要连接
                values[u] = (values[u] + values[v]) % k;
            }
            cnt += child[1];
        }

        // 如果连通块满足条件，则不需要连接
        // System.out.println(u + " " + values[u]);
        if(values[u] == 0){
            cnt++;
            res[0] = 0;
        }else{
            res[0] = 1;
        }
        res[1] = cnt;
        return res;
    }
}
