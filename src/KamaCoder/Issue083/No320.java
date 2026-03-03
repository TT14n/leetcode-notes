package KamaCoder.Issue083;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class No320 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] parts;
        parts = br.readLine().split(" ");

        int s = Integer.parseInt(parts[0]);
        int n = Integer.parseInt(parts[1]);
        int m = Integer.parseInt(parts[2]);

        int[][] strategy = new int[n][s]; 

        // 策略为行，玩家为列
        for(int j=0; j<s; j++){
            parts = br.readLine().split(" ");
            for(int i=0; i<n; i++){
                strategy[i][j] = Integer.parseInt(parts[i]);
            }
        }

        // 对策略进行遍历
        int[] f = new int[m+1];
        for(int i=0; i<n; i++){
            // 1. 对每个策略行进行排序
            Arrays.sort(strategy[i]);

            // 2. 背包策略，选择战胜几个人 
            for(int v=m; v >= 2*strategy[i][0]+1; v--){
                for(int j=0; j<s; j++){
                    int cost = 2*strategy[i][j]+1;
                    if(v < cost){
                        break;
                    }
                    int reward = (i+1) * (j+1);
                    f[v] = Math.max(f[v], f[v-cost] + reward);
                }
                
            }
        }

           
        bw.write(Integer.toString(f[m]));
        bw.newLine();
        

        br.close();
        bw.close();
    }
}
