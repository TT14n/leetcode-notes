package KamaCoder.Issue085;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No324 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        // 因为两次 xor 可以还原，所以虽然题目是相邻的数字才能 xor
        // 但是实际上可以让任意的数字进行 xor，不过要保证进行 xor 的数字 a 的数目应该为偶数
        while (T > 0) {
            T--;
            String[] parts;
            parts = br.readLine().split(" ");
            int n = Integer.parseInt(parts[0]);
            int x = Integer.parseInt(parts[1]);

            // int[] a = new int[n];
            // 因为要保证是偶数，所以可能不能把所有提供增量的数字都包含
            // 要进行取舍，一方面是可以 + 一个最少的减量，另一方面可以 - 一个最小的增量
            int sum = 0;
            int minPlus = 1000; // 加的最少的
            int maxSub = -1000; // 减的最少的
            int cnt = 0;
            parts = br.readLine().split(" ");
            for(int i=0; i<n; i++){
                // a[i] = Integer.parseInt(parts[i]);
                int a = Integer.parseInt(parts[i]);
                int xor = a ^ x;
                if(xor > a){
                    minPlus = Math.min(minPlus, xor-a);
                    cnt++;
                    sum += xor;
                }else{
                    maxSub = Math.max(maxSub, xor-a);
                    sum += a;
                }
            }

            if(cnt % 2 == 0){
                System.out.println(sum);
            }else{
                if(minPlus + maxSub > 0){
                    System.out.println(sum + maxSub);
                }else{
                    System.out.println(sum - minPlus);
                }
            }

        }

    }
}
