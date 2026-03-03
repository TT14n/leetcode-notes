package KamaCoder.Issue094;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class No348 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] parts = br.readLine().split(" ");
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(parts[i]);
        }
        Arrays.sort(nums);
        
        int r = nums.length / 2;
        int l = r - 1;
        // order = 1 时，nums[l] 是中位数，否则 nums[r]
        int order = nums.length % 2 == 0 ? 1 : 0;
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            if(order == 1){
                sb.append(nums[l]);
                l--;
            }else{
                sb.append(nums[r]);
                r++;
            }
            sb.append(" ");
            order ^= 1;
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.close();
    }
}
