package KamaCoder.Issue093;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No257 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] parts = br.readLine().split(" ");
        int[] a = new int[n];
        int ans = 1;
        int cnt = 1;
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(parts[i]);
            if(a[i] == 0){
                cnt++;
            }else{
                ans = Math.max(ans, cnt);
                cnt = 1;
            }
        }
        ans = Math.max(ans, cnt);
        bw.write(Integer.toString(ans));
        bw.newLine();


        br.close();
        bw.close();
    }
}
