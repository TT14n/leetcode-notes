package KamaCoder.Issue088;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No333 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int n = chars.length;
        int head = 0;
        for(int i=1; i<n; i++){
            int p1 = i;
            int p2 = head;
            int cnt = 0;
            while (cnt < n && chars[p1] == chars[p2]) {
                p1 = (p1 + 1) % n;
                p2 = (p2 + 1) % n;
                cnt++;
            }
            if(chars[p1] > chars[p2]){
                head = i;
            }
        }
        int p = head;
        int cnt = 0;
        while (cnt < n) {
            System.out.print(chars[p]);
            p = (p+1)%n;
            cnt++;
        }
    }
}
