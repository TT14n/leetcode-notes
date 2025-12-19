package KamaCoder.Issue089;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.ArrayList;

public class No336 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] parts = br.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        char[][] S = new char[n][m];
        for(int i=0; i<n; i++){
            int j = 0;
            for(char c : br.readLine().toCharArray()){
                S[i][j++] = c;
            }
        }

        int[][] map = new int[n][m];
        // 染色法
        int color = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0){
                    dfs(color++, map, S, i, j, n, m);
                }
            }
        }
        // for(int i=0; i<n; i++){
        //     System.out.println(Arrays.toString(map[i]));
        // }

        ArrayList<HashSet<Character>> cnt = new ArrayList<>();
        for(int i=1; i<color; i++){
            cnt.add(new HashSet<>());
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int k=0; k<4; k++){
                    int xx = i + direct[k][0];
                    int yy = j + direct[k][1];
                    if(xx>=0 && xx<n && yy>=0 && yy<m && map[i][j] != map[xx][yy]){
                        cnt.get(map[i][j]-1).add(S[xx][yy]);
                    }
                }
            }
        }

        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<m; j++){
                sb.append(cnt.get(map[i][j]-1).size() + " ");
                // for(char num : cnt.get(map[i][j])){

                //     bw.write(num + " ");
                // }
                // bw.newLine();
            }
            bw.write(sb.toString());
            bw.newLine();
        }
        br.close();
        bw.close();
        
    }
    static int[][] direct = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    static void dfs(int color, int[][] map, char[][] S, int x, int y, int n, int m){
        map[x][y] = color;
        for(int i=0; i<4; i++){
            int xx = x + direct[i][0];
            int yy = y + direct[i][1];
            if(xx>=0 && xx<n && yy>=0 && yy<m && map[xx][yy] == 0 && S[x][y] == S[xx][yy]){
                dfs(color, map, S, xx, yy, n, m);
            }
        }
        
    }

}
