package KamaCoder.Issue092;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No346 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out)); 

        char[] s = br.readLine().toCharArray();
        int n = s.length;
        // 找到最长的连续的 0
        int longestZerolen = 0;
        int len = 0;
        boolean flag = true;
        int i = 0;
        while((flag || len > 0) && len < n){
            if(s[i] == '1'){
                longestZerolen = Math.max(len, longestZerolen);
                len = 0;
            }else{
                len++;
            }
            
            i++;
            if(i == n){
                flag = false;
                i = 0;
            }
        }


        if(len > longestZerolen){
            longestZerolen = len;
        }
     
        int ans = 0;
        if(longestZerolen == n){
            ans = n*n;
        }else{
            ans = longestZerolen * (longestZerolen+1) / 2;
        }

        bw.write(Integer.toString(ans));
        bw.newLine();

        br.close();
        bw.close();
    }
}
