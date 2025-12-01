package KamaCoder.Issue086;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
 
public class Main {
    public static void main(String[] args) throws Exception {
        // read part
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts;
        
        // n
        int n = Integer.parseInt(br.readLine()); 
        
        // b[]
        int[] b = new int[n]; 
        parts = br.readLine().trim().split(" ");
        for(int i=0; i<n; i++){
            b[i] = Integer.parseInt(parts[i]);
        }

        // <u,v>
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n-1; i++){
            parts = br.readLine().trim().split(" ");
            int u = Integer.parseInt(parts[0])-1;
            int v = Integer.parseInt(parts[1])-1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // for(int i=0; i<n; i++){
        //     System.out.println(adj.get(i));
        // }
    
    
     
    }
 
}