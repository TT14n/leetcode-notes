package KamaCoder.Issue091;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class No342 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] parts;
        parts = br.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int q = Integer.parseInt(parts[1]);
        char[] chars = br.readLine().toCharArray();
        ArrayList<HashMap<String, Integer>> arr = new ArrayList<>();
        for(int len=1; len<=Math.min(10, n); len++){
            HashMap<String, Integer> map = new HashMap<>();
            for(int i=0; i<n-len+1; i++){
                map.merge(new String(chars, i, len), 1, (oldValue, newValue) -> oldValue + newValue);
            }
            // System.out.println(map.toString());
            arr.add(map);
        }


        while (q > 0) {
            q--;
            String query = br.readLine();
            int cnt = arr.get(query.length()-1).getOrDefault(query, 0);
            bw.write(Integer.toString(cnt));
            bw.newLine();
        }
        
        br.close();
        bw.close();

    }
}
