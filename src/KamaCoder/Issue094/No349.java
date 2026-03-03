
package KamaCoder.Issue094;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No349 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            T--;
            int n = Integer.parseInt(br.readLine());
            // 骗人的题，只要考虑 2^n 即可

            int m = 0;
            StringBuilder sb = new StringBuilder();
            int k = 1;
            while (n >= k) {
                k <<= 1;
            }
            k >>= 1;
            while (k > 0) {
                if ((n & k) > 0){
                    m++;
                    sb.append(k).append(" ");
                }
                k >>= 1;
            }
           
            
            
            
            bw.write(Integer.toString(m));
            bw.newLine();
            bw.write(sb.toString().trim());
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
