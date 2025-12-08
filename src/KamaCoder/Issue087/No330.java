package KamaCoder.Issue087;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No330 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        double r = Integer.parseInt(parts[0]);
        int n = Integer.parseInt(parts[1]);
        double pi = 3.141592654;
        int x = 0;
        double ans = 0;
        while (n > 0) {
            if(x == 0){
                ans += 3.0/4*pi*r*r;
            }else{
                ans -= 3.0/4*pi*r*r;
            }

            r /= 2;
            x ^= 1;
            n--;
        }

        System.out.printf("%.7f", ans);

    }
}
