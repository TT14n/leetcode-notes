package KamaCoder.Issue083;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No319 {
    private static long quick_pow(long x, long pow, long mod){
        long ans = 1;
        x = x % mod;
        while (pow > 0) {
            if((pow & 1) > 0){
                ans = ans * x % mod;
            } 
            pow = pow >> 1;
            x = x * x % mod;
        }
        return ans;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int MOD = 9_9824_4353;
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            T--;
            int n = Integer.parseInt(br.readLine());
            int[] nums = new int[n];
            String[] parts = br.readLine().split(" ");
            for(int i=0; i<n; i++){
                nums[i] = Integer.parseInt(parts[i]);
            }

            int maxNum = 0;
            int cnt = 0;
            // 1. 前面不会有数大于 nums[i] 
            // 2. 后面不会有数小于 nums[i]
            for(int i=0; i<n; i++){
                if(nums[i] == i+1 && maxNum < nums[i]){
                    cnt++;
                }
                maxNum = Math.max(maxNum, nums[i]);
            }

            long ans = quick_pow(2, cnt, MOD);
            if(cnt == n){
                ans--;
            }

            bw.write(Long.toString(ans));
            bw.newLine();
        }


        br.close();
        bw.close();
    }
}
