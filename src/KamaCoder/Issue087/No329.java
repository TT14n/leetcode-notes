package KamaCoder.Issue087;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No329 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            T--;
            int n = Integer.parseInt(br.readLine());
            String[] parts = br.readLine().split(" ");
            int num;
            int max1 = 0, max2 = 0;
            int min1 = 1000000, min2 = 1000000;
            for(int i=0; i<n; i++){
                num = Integer.parseInt(parts[i]);
                if(num > max1){
                    max2 = max1;
                    max1 = num;
                }else if(num > max2){
                    max2 = num;
                }

                if(num < min1){
                    min2 = min1;
                    min1 = num;
                }else if(num < min2){
                    min2 = num;
                }
            }

            // 考虑是删除 max1 还是 min1
            int ans = Math.min(max2-min1, max1-min2);
            System.out.println(ans);

        }
    }
}
