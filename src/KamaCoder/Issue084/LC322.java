
package KamaCoder.Issue084;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LC322 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 输入数据
        String[] parts;
        parts = br.readLine().split(" ");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        int n = Integer.parseInt(parts[2]);

        int[] mArr = new int[200];
        int[] xArr = new int[200];
        int[] yArr = new int[200];
        int len = 0;
        for(int i=0; i<n; i++){
            int mi, xi, yi, ki;
            parts = br.readLine().split(" ");
            mi = Integer.parseInt(parts[0]);
            xi = Integer.parseInt(parts[1]);
            yi = Integer.parseInt(parts[2]);
            ki = Integer.parseInt(parts[3]);
            mArr[len] = mi;
            xArr[len] = xi;
            yArr[len] = yi;
            len++;
            for(int j=0; j<ki; j++){
                int mij, xij, yij;
                parts = br.readLine().split(" ");
                mij = mi + Integer.parseInt(parts[0]);
                xij = xi + Integer.parseInt(parts[1]);
                yij = yi + Integer.parseInt(parts[2]);
                mArr[len] = mij;
                xArr[len] = xij;
                yArr[len] = yij;
                len++;
            }
        }

        // 动态规划
        int[][] dp = new int[x+1][y+1];
        // 初始化
        int INF = 1_0000_0000;
        for(int i=0; i<=x; i++){
            for(int j=0; j<=y; j++){
                dp[i][j] = INF;
            }
        }

        dp[0][0] = 0;
        for(int i=0; i<len; i++){
            for(int vx = 0; vx < x; vx++){
                for(int vy = 0; vy < y; vy++){
                    if(dp[vx][vy] == INF){
                        continue;
                    }
                    int x1 = vx;
                    int y1 = vy;
                    int x2 = Math.min(x1 + xArr[i], x);
                    int y2 = Math.min(y1 + yArr[i], y);
                    while(dp[x1][y1] + mArr[i] < dp[x2][y2]){
                        dp[x2][y2] = dp[x1][y1] + mArr[i];
                        x1 = x2;
                        y1 = y2;
                        x2 = Math.min(x1 + xArr[i], x);
                        y2 = Math.min(y1 + yArr[i], y);
                    }
                    
                }
            }
        }

        // for(int i=0; i<len; i++){
        //     System.out.println("方案" + i + ": " + mArr[i] + " " + xArr[i] + " " + yArr[i]);
        // }
        // for(int i=0; i<=x; i++){
        //     for(int j=0; j<=y; j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        

        bw.write(Integer.toString(dp[x][y]));
        bw.newLine();

        br.close();
        bw.close();


    }
}
