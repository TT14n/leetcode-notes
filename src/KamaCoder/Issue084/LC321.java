
package KamaCoder.Issue084;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class LC321 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] parts;
        parts = br.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);
        parts = br.readLine().split(" ");
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(parts[i]);
        }

        int[] duration = new int[n-1];
        for(int i=1; i<n; i++){
            duration[i-1] = nums[i] - nums[i-1] - 1;
        }

        // 在珠峰大本营生活不超过总共k天的前提下，贪心挑选间隔时间最短的
        int ans = n * 2;
        k -= n;
        Arrays.sort(duration);
        for(int i=0; i<n-1; i++){
            if(duration[i] <= k){
                k -= duration[i];
                ans -= 2;
            }else{
                break;
            }
        }

        bw.write(Integer.toString(ans));
        bw.newLine();

        br.close();
        bw.close();


    }
}
