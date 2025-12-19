
package KamaCoder.Issue086;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 
public class No328 {
    static long ans = 0;
    public static void main(String[] args) throws Exception {
        // read part
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts;
        
        // n
        int n = Integer.parseInt(br.readLine()); 
        
        // b[]
        int[] b = new int[n]; 
        parts = br.readLine().trim().split(" ");
        for(int i=0; i<n; i++){
            b[i] = Integer.parseInt(parts[i]);
        }

        // <u,v>
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n-1; i++){
            parts = br.readLine().trim().split(" ");
            int u = Integer.parseInt(parts[0])-1;
            int v = Integer.parseInt(parts[1])-1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        
        // for(int i=0; i<n; i++){
        //     System.out.println(adj.get(i));
        // }
        
        // 把 0 作为根节点
        int[] visited = new int[n];
        long cnt = dfs(0, visited, adj, b);
        if(cnt > 0){
            ans += cnt*(cnt-1)/2;
        }
        System.out.println(ans); 
        
    }

    // 返回连通块的节点数量
    static long dfs(int u, int[] visited, ArrayList<ArrayList<Integer>> adj, int[] b){
        visited[u] = 1;
        int mod = b[u] % 2;
        int sum = 0;
        if(mod==0){
            sum++;
            ans++;
        }
        for(int v : adj.get(u)){
            if(visited[v] == 1){
                continue;
            } 
            long cnt = dfs(v, visited, adj, b);
            if(mod == 1){
                if(cnt > 0){
                    ans += cnt*(cnt-1)/2;
                }
                continue;
            }
            sum += cnt;
        }
        
        return sum;
    }
 
}