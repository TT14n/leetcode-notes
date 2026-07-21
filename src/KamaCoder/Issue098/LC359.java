package KamaCoder.Issue098;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LC359 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int P = Integer.parseInt(br.readLine());
        String[] parts;
        for(int p = 0; p < P; p++){
            parts = br.readLine().split(" ");
            int T = Integer.parseInt(parts[0]);
            int C = Integer.parseInt(parts[1]);
            int N = Integer.parseInt(parts[2]);
            int M = Integer.parseInt(parts[3]);

            int[] skill = new int[N];
            int[] enemy = new int[M];

            parts = br.readLine().split(" ");
            for(int i=0; i<N; i++) skill[i] = Integer.parseInt(parts[i]);
            parts = br.readLine().split(" ");
            for(int i=0; i<M; i++) enemy[i] = Integer.parseInt(parts[i]);

            int pre = -2 * Math.max(T, C); // 上一次释放的时间
            int i=0, j=0;
            int ans = 0;
            int cnt = 0;
            while (i<N && j<M) {
                // 释放技能
                // System.out.println(skill[i] + " " + enemy[j] + ": " + cnt + " " + pre);
                if(skill[i] < enemy[j]){
                    // 需要大于冷却时间
                    if(skill[i] - pre >= C){
                        pre = skill[i];
                        cnt = 0;
                    }
                    i++;
                }else if(skill[i] > enemy[j]){
                    // 需要小于释放时间
                    if(enemy[j] - pre < T){
                        cnt++;
                        ans = Math.max(ans, cnt);
                    }
                    j++;

                }else{
                    if(skill[i] - pre >= C){
                        pre = skill[i];
                        cnt++;
                    }
                    if(enemy[j] - pre < T){
                        cnt++;
                        ans = Math.max(ans, cnt);
                    }
                    i++;
                    j++;
                }

            }
            bw.write(Integer.toString(ans));
            bw.newLine();
            
        }

       


        br.close();
        bw.close();
    }
}
