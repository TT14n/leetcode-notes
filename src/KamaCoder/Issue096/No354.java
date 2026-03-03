package KamaCoder.Issue096;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class NodeConvert{
    char[] nodes = new char[26];
    int cnt;

    int toInt(char c){
        for(int i=0; i<cnt; i++){
            if(nodes[i] == c){
                return i;
            }
        }
        nodes[cnt] = c;
        return cnt++;   
    }

    char toChar(int i){
        return nodes[i];
    }
}

public class No354 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            

        NodeConvert convert = new NodeConvert();
        int n = Integer.parseInt(br.readLine());
        String[] parts;
        parts = br.readLine().split(" ");
        
        int s = convert.toInt(parts[0].charAt(0));
        int t = convert.toInt(parts[1].charAt(0));

        int[][] matrix = new int[n][n];
        int inf = 1000_0000;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = inf;
                matrix[j][i] = inf;
            }
            matrix[i][i] = 0;
        }

        
        while (true) {
            parts = br.readLine().split(" ");
            if(parts[0].equals("0000")){
                break;
            }

            int u = convert.toInt(parts[0].charAt(0));
            int v = convert.toInt(parts[1].charAt(0));
            matrix[u][v] = Integer.parseInt(parts[2]);
            matrix[v][u] = Integer.parseInt(parts[2]);
        }

        // Dijkstra
        // System.out.println(convert.cnt);
        int[] preNode = new int[n];
        int[] dist = new int[n];
        int[] visited = new int[n];
        visited[s] = 1;
        for(int i=0; i<n; i++){
            dist[i] = matrix[s][i];
            preNode[i] = s;
        }

        for(int k=0; k<n-1; k++){
            int minDist = inf;
            int u = -1;

            // 找到当前距离最小的点
            for(int i=0; i<n; i++){
                if(visited[i] == 0 && dist[i] < minDist){
                    minDist = dist[i];
                    u = i;
                }
            }
            visited[u] = 1;

            if(u == t){
                break;
            }

            // 更新其他点
            // System.out.println(u + " " + dist[u]);
            for(int i=0; i<n; i++){
                if(dist[i] > dist[u] + matrix[u][i]){
                    dist[i] = dist[u] + matrix[u][i];
                    preNode[i] = u;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int u = t;
        sb.append(convert.toChar(u));
        while (u != s) {
            u = preNode[u];
            sb.append(" ").append(convert.toChar(u));
        }

        sb.reverse();
        bw.write(sb.toString());
        
        br.close();
        bw.close();
    }
}
        
    
