package KamaCoder.Issue095;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No351 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] parts = br.readLine().split(",");
        int n = parts.length;        
        int i = 0;
        int l = 1;
        while (i < n) {
            
            StringBuilder sb = new StringBuilder();
            int j = i;
            for(; j<Math.min(i+l, n); j++){
                if(parts[j].equals("#")){
                    continue;
                }
                sb.append(parts[j] + " ");
            }
            l = l * 2;
            i = j;
            bw.write(sb.toString().trim());
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
