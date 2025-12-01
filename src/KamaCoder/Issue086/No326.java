package KamaCoder.Issue086;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No326 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            int[] nums = new int[n];
            String[] parts = br.readLine().trim().split(" ");
            
            for(int i=0; i<n; i++){
                nums[i] = Integer.parseInt(parts[i]);
            }
            // sc.nextLine();
            Arrays.sort(nums);
            // System.out.println(Arrays.toString(nums));
            int ans = 0;
            for(int i=0; i<n; i++){
                ans = Math.max(ans, nums[i] + n - i);
            }
            System.out.println(ans);
        }  
        
    }

}

