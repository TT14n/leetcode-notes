package KamaCoder.Issue093;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No259 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();

        long cnt11 = 0L;
        long cnt114 = 0L;
        long cnt1145 = 0L;
        long MOD = 10_0000_0000 + 7L;
        for(int i=1; i<n; i++){
            if(chars[i] == '1'){
                if(chars[i-1] == '1'){
                    cnt11++;
                }
            }else if(chars[i] == '4'){
                cnt114 = (cnt114 + cnt11) % MOD;
            }else if(chars[i] == '5'){
                cnt1145 = (cnt1145 + cnt114) % MOD;
            }
        }
        
        bw.write(Long.toString(cnt1145));
        bw.newLine();

        br.close();
        bw.close();
    }
}
