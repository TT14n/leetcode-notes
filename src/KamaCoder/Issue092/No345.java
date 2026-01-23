package KamaCoder.Issue092;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No345 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] parts = br.readLine().split(" ");
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(parts[i]);
        }
        int minNum = nums[0];
        int maxNum = nums[0];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            minNum = Math.min(nums[i], minNum);
            maxNum = Math.max(nums[i], maxNum);
            if(0 < minNum){
                sb.append("0 ");
            }else{
                sb.append((maxNum+1) + " ");
            }
        }
        
        bw.write(sb.toString().trim());
        bw.newLine();

        br.close();
        bw.close();
    }
}
