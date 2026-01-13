package KamaCoder.Issue091;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No343 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] parts;
        parts = br.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);
        char[] chars = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        sb.append(new String(chars, k-1, n-k+1));
        // 翻转次数 n-k+1
        if((n-k+1) % 2 == 1){
            sb.append(new StringBuffer(new String(chars, 0, k-1)).reverse());
        }else{
            sb.append(new String(chars, 0, k-1));
        }
        bw.write(sb.toString());
        bw.newLine();
        
        br.close();
        bw.close();

    }
}
