package KamaCoder.Issue090;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No339 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        
        // 给定一个整数，请你判断它是否可以写成4个质数之和。若可以，请输出字典序最小的方案；否则输出-1。

        // 哥德巴赫：任意一个 >2 的偶数，都可以表示为两个质数之和
        // 由于 8 <= n <= 10^9.
        // 1. 当 n 为偶数时，则有 (2,2,p,q) 其中 p<=q 为结果
        // 2. 当 n 为奇数时，
        //  则有
        //  2.1 (2,2,2,p) 
        //  2.2 (2,3,p,q) 其中 p<=q 为结果
        //  这是因为：偶数为质数的数只有 2
        //  因为 p + q 为偶数，若 p=2，则q只能为2，被(2,2,2,p)包含
        //  否则 p>=3，符合最小排列规则
        while (t > 0) {
            t--;
            int n = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            if(n == 8){ // (2,2,2,2) 特判
                bw.write("2 2 2 2");
                bw.newLine();
                continue;
            }
            if(n % 2 == 0){
                n = n - 4;
                sb.append("2 2 ");
            }else{
                // (2,2,2,p) 特判
                if(isPrime(n-6)){
                    bw.write("2 2 2 " + (n-6));
                    bw.newLine();
                    continue;
                }
                n = n - 5;
                sb.append("2 3 ");
            }

            // 判断 (p, q)
            if(isPrime(n-3)){
                sb.append("3 " + (n-3));
            }else{
                // 6n-1 6n+1
                for(int p=5; p<=n/2; p+=6){
                    if(isPrime(p) && isPrime(n-p)){
                        sb.append("" + p + " " + (n-p));
                        break;
                    }
                    if(isPrime(p+2) && isPrime(n-p-2)){
                        sb.append("" + (p+2) + " " + (n-p-2));
                        break;
                    }
                }
            }


            bw.write(sb.toString());
            bw.newLine();
            continue;
            
        }

        br.close();
        bw.close();
    }

    private static boolean isPrime(int num) {
        for(int r=2; r<=Math.sqrt(num); r++){
            if(num%r==0){
                return false;
            }
        }
        return true;
    }
}
