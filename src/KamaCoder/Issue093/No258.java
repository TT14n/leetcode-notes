package KamaCoder.Issue093;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No258{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] parts;
        parts = br.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);
        parts = br.readLine().split(" ");
        int[] a = new int[n];
        boolean isDivide = true;
        int ans = 0;
        int sum = 0;
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(parts[i]);
            if(a[i] > k){
                isDivide = false;
                break;
            }

            if((sum | a[i]) > k){
                sum = a[i];
                ans++;
            }else{
                sum |= a[i];
            }
            System.out.println(ans + " " + sum);
        }

        ans++;
        if(isDivide){
            bw.write(Integer.toString(ans));
        }else{
            bw.write("-1");
        }
        bw.newLine();

       

        br.close();
        bw.close();
    }
}
