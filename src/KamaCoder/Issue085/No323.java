package KamaCoder.Issue085;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class No323 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            T--;
            String[] parts;
            parts = br.readLine().split(" ");
            int n = Integer.parseInt(parts[0]);
            int l = Integer.parseInt(parts[1]);
            int r = Integer.parseInt(parts[2]);

            int[] nums = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            parts = br.readLine().split(" ");
            for(int i=0; i<n; i++){
                nums[i] = Integer.parseInt(parts[i]);
                map.merge(nums[i], 1, Integer::sum);
            }

            StringBuilder sb = new StringBuilder();
            int len = 0;
            for(int i=0; i<n ;i++){
                if(l <= map.get(nums[i]) && map.get(nums[i]) <= r){
                    continue;
                }
                len++;
                if(!sb.isEmpty()) sb.append(" ");
                sb.append(nums[i]);
            }
            System.out.println(len);
            System.out.println(sb.toString());
        }

    }
}
