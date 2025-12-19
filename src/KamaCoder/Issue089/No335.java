package KamaCoder.Issue089;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No335 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] parts = br.readLine().split(" ");
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(parts[i]);
        }

        long ans = 0;
        int[] record = new int[3];
        for(int i=0; i<3; i++){
            record[i] = -1;
        }
        // 以 r 为末尾
        for(int r=0; r<n; r++){
            record[a[r]] = r; // 保留最新的值      
            int minr = r;
            // [0, r0] 之间 +1
            // [0, min(r1, r0)] 之间 +1
            // [0, min(r1, r0, r2)] 之间 +1
            for(int i=0; i<3; i++){
                if(record[i] == -1){
                    break;
                }
                minr = Math.min(minr, record[i]);
                ans += minr + 1;
            }
        
        }
        System.out.println(ans);
    }
}

