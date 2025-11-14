package disjointset;
import java.util.ArrayList;
import java.util.HashMap;

public class LC3607 {
    int[] fa;
    int findFather(int x){
        if(x==fa[x]){
            return x;
        }else{
            int father = findFather(fa[x]);
            fa[x] = father;
            return father;
        }
    }
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        
        int[] online = new int[c+1];
        // 并查集
        fa = new int[c+1];
        for(int i=1; i<=c; i++){
            fa[i] = i;
        }
        for(int i=0; i<connections.length; i++){
            int u = connections[i][0];
            int v = connections[i][1];
            fa[findFather(u)] = findFather(v);
        }

        // 倒序处理
        int[] offlineCnt = new int[c+1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<queries.length; i++){
            if(queries[i][0] == 2){
                offlineCnt[queries[i][1]]++;
            }
        }
        for(int i=1; i<=c; i++){
            if(offlineCnt[i] == 0){
                online[i] = 1;
                int father = findFather(i);
                if(map.containsKey(father)){
                    map.put(father, Math.min(map.get(father), i));
                }else{
                    map.put(father, i);
                }
            }
        } 

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=queries.length-1; i>=0; i--){
            int x = queries[i][1];
            if(queries[i][0] == 1){
                if(online[x] == 1){
                    arr.add(x);
                }else{
                    arr.add(map.getOrDefault(findFather(x),-1));
                }
            }else{
                offlineCnt[x]--;
                if(offlineCnt[x] == 0){
                    online[x] = 1;
                    int father = findFather(x);
                    // System.out.println(x  + " " + father + " " + map.get(father));
                    if(map.containsKey(father)){
                        map.put(father, Math.min(map.get(father), x));
                    }else{
                        map.put(father, x);
                    }
                }
            }
        }

        int[] results = new int[arr.size()];
        for(int i=0; i<arr.size(); i++){
            results[i] = arr.get(arr.size()-i-1);
        }
        return results;

    }

    public static void main(String[] args) {
        LC3607 solution = new LC3607();
        int[] results = solution.processQueries(5, new int[][]{{1,2},{2,3},{3,4},{4,5}}, new int[][]{{1,3},{2,1},{1,1},{2,2},{1,2}});
        for(int i=0; i<results.length; i++){
            System.out.print(results[i] + " ");
        }
    }
    
}
