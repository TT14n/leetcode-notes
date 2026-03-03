package KamaCoder.Issue095;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No350 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] parts = br.readLine().split(" ");
        int sum = 0;
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(parts[i]);
            sum += nums[i]; 
        }
        if(sum % 2 == 1){
            bw.write(Boolean.toString(false));
        }else{
            // dp
            int[] dp = new int[sum/2+1];
            dp[0] = 1;
            int maxv = 0;
            for(int i=0; i<n; i++){
                maxv = Math.min(maxv+nums[i], sum/2);
                for(int v=maxv; v>=nums[i]; v--){
                    dp[v] |= dp[v - nums[i]];
                }
            }
            bw.write(Boolean.toString(dp[sum/2] == 1));
        }
        

        br.close();
        bw.close();
    }
}
