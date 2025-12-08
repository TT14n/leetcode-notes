package KamaCoder.Issue087;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class No331 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int k = Integer.parseInt(parts[2]);
        int q = Integer.parseInt(parts[3]);
        parts = br.readLine().split(" ");
        long[] dijk = new long[n+1];
        PriorityQueue<long[]> heap = new PriorityQueue<>((a,b) -> Long.compare(a[1], b[1])); 
        for(int i=0; i<=n; i++){
            dijk[i] = Long.MAX_VALUE / 2;
        }
        for(int i=0; i<k; i++){
            int p = Integer.parseInt(parts[i]);
            dijk[p] = 0L;
            heap.add(new long[]{p, 0L});
        }

        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for(int i=0; i<m; i++){
            parts = br.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            int c = Integer.parseInt(parts[2]);
            map.putIfAbsent(a, new HashMap<>());
            map.putIfAbsent(b, new HashMap<>());
            map.get(a).put(b, c);
            map.get(b).put(a, c);
        }

        

        int[] visited = new int[n+1];
        for(int t=0; t<n; t++){
            while(visited[(int)heap.peek()[0]] == 1){
                heap.poll();
            }
            long[] firstVal = heap.poll();
            int u = (int)firstVal[0];
            visited[u] = 1;
            HashMap<Integer, Integer> nodes = map.get(u);
            for(int v : nodes.keySet()){
                if(dijk[v] > dijk[u] + nodes.get(v)){
                    dijk[v] = dijk[u] + nodes.get(v);
                    heap.add(new long[]{v, dijk[v]});
                }
            }
        }
        
        for(int i=0; i<q; i++){
            int query = Integer.parseInt(br.readLine()); 
            System.out.println(dijk[query]);
        }

        

    }
}
