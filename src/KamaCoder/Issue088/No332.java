package KamaCoder.Issue088;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class No332 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int[] ans = new int[m];
        int t = 0;
        while (t < m) {
            HashMap<Character, Integer> map = new HashMap<>();
            char[] chars = br.readLine().toCharArray();
            int i = 0;
            while (i < chars.length) {
                while (i+1 < chars.length && chars[i] == chars[i+1]) {
                    i++;
                }
                map.merge(chars[i], 1, Integer::sum);
                i++;
            }

            for(char c : map.keySet()){
                ans[t] += map.get(c) > n ? 1 : 0;
            }

            t++;
        }

        for(int i=0; i<m; i++){
            if(ans[i] <= 1){
                System.out.println(1);
            }else{
                System.out.println(ans[i]);
            }
        }

    }
}
