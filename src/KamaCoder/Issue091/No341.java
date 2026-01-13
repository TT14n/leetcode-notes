package KamaCoder.Issue091;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class No341 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            T--;
            int n = Integer.parseInt(br.readLine());
            int[] nums = new int[n];
            String[] parts = br.readLine().split(" ");
            for(int i=0; i<n; i++){
                nums[i] = Integer.parseInt(parts[i]);
            }
            Arrays.sort(nums);
            if(nums[n-1] >= nums[0] + nums[1]){
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
