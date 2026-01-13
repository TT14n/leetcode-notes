package KamaCoder.Issue091;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No344 {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        int[] aCnt = new int[n+1];
        int[] bCnt = new int[n+1];

        for(int i=0; i<n; i++){
            String[] parts = br.readLine().split(" ");
            a[i] = Integer.parseInt(parts[0]);
            b[i] = Integer.parseInt(parts[1]);
            aCnt[a[i]]++;
            bCnt[b[i]]++;
        }
        // 不重复的情况比较难考虑，反向思考重复的情况：
        // 1. 两个a相同，但b不同
        // 2. 两个b相同，但a不同
        // 3. 两个a相同，两个b相同
        // 4. 三个a相同
        // 5. 三个b相同
        // 相同的情况比较好考虑，但是不同的情况比较难考虑
        // 于是 1 2 3 三种情况还需要再转换
        // 我们可以只考虑 (1)两个a相同的情况 加上 (2)两个b相同的情况
        // (1) 与 (2) 重复了一次 3 的情况，把它减掉即可

        // 最终，我们要考虑
        // 1. 两个a相同
        // 2. 两个b相同
        // 3. 两个a相同，两个b相同
        // 4. 三个a相同
        // 5. 三个b相同
        // ans = 1+2-3+4+5

        // 统计 1 4 的情况
        long repCnt = 0;
        for(int cnt : aCnt){
            if(cnt >= 2){
                repCnt += (long)cnt * (cnt-1) / 2 * (n-cnt);
                if(cnt >= 3){
                    repCnt += (long)cnt * (cnt-1) * (cnt-2) / 6;
                }
            }
        }

        // 统计 2 5 的情况
        for(int cnt : bCnt){
            if(cnt >= 2){
                repCnt += (long)cnt * (cnt-1) / 2 * (n-cnt);
                if(cnt >= 3){
                    repCnt += (long)cnt * (cnt-1) * (cnt-2) / 6;
                }
            }
        }
        
        // 统计 3 的情况
        for(int i=0; i<n; i++){
            if(aCnt[a[i]] >= 2 && bCnt[b[i]] >= 2){
                int cnt1 = aCnt[a[i]];
                int cnt2 = bCnt[b[i]]; 
                repCnt -= (cnt1 - 1) * (cnt2 - 1); 
            }
        }

        long total = (long)n * (n-1) * (n-2) / 6;
        long ans = total - repCnt;


        bw.write(Long.toString(ans));
        bw.newLine();
        
        br.close();
        bw.close();

    }
}
