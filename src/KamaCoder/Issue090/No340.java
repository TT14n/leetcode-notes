package KamaCoder.Issue090;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;


public class No340 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] parts;
        parts = br.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);
        
        Map<Integer, Integer> map = new HashMap<>();
        parts = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(parts[i]);
            map.merge(num, 1, (oldValue, newValue) -> oldValue + newValue);
        }

        int ans = 0;
        for(Integer key : map.keySet()){
            if(key*2 == k){ // 和自身相加为 k 时，需要特判
                continue;
            }
            ans += Math.min(map.get(key), map.getOrDefault(k-key, 0));
        }
        ans /= 2;
        if(k%2==0){
            ans += Math.max(map.getOrDefault(k/2, 0) - 1, 0);
        }
        bw.write(Integer.toString(ans));

        br.close();
        bw.close();
    }
}
