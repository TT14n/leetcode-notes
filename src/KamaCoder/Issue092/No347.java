
package KamaCoder.Issue092;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class No347 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out)); 

        int n = Integer.parseInt(br.readLine());
        String[] parts = br.readLine().split(" ");
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(parts[i]);
        }

        Arrays.sort(nums);
        int MAX_NUM = 1_000_000;
        int[] record = new int[MAX_NUM + 1];
        for(int i=0; i<n; i++){
            if(i>0 && nums[i] == nums[i-1]){
                long mul = (long)nums[i] * nums[i];
                if(mul <= MAX_NUM){
                    record[(int)mul] = 1;
                }
                continue;
            }
            for(int j=0; j<i; j++){
                if(j>0 && nums[j] == nums[j-1]){
                    continue;
                }
                long mul = (long)nums[i] * nums[j];
                if(mul > MAX_NUM){
                    break;
                }
                record[(int)mul] = 1;
             }
        }


        int q = Integer.parseInt(br.readLine());
        for(int i=0; i<q; i++){
            int x = Integer.parseInt(br.readLine());
            if(record[x] == 1){
                bw.write("Yes");
            }else{
                bw.write("No");
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
