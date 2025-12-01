package KamaCoder.Issue086;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class No327_sol2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts;
        parts = br.readLine().trim().split(" ");
        int n = Integer.parseInt(parts[0]), k = Integer.parseInt(parts[1]);
        parts = br.readLine().trim().split(" ");
        int[] nums = new int[n];
        int maxNum = 0;
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(parts[i]);
            maxNum = Math.max(maxNum, nums[i]);
        }

        // 如何快速求解质因子个数？
        int[] prime = new int[maxNum+1];
        for(int i=2; i<=maxNum; i++){
            int cnt = 0;
            int r = 2;
            int x = i;
            while(r <= x){
                if(x % r == 0){
                    while (x % r == 0) { // 被除的一定是质数
                        x/=r;
                    }
                    cnt++;
                }
                r++;
            }
            prime[i] = cnt;
            
        }

        // System.out.println(Arrays.toString(prime));
        // System.out.println(Arrays.toString(Arrays.stream(nums).map(x->prime[x]).toArray()));
        // 求解最小的长度为 k 的子数组
        int now = 0;
        for(int i=0; i<k-1; i++){
            now += prime[nums[i]];
        }
        
        int res = Integer.MAX_VALUE / 2;
        int sum = now;
        for(int r=k-1; r<n; r++){
            now += prime[nums[r]];
            sum += prime[nums[r]];
            res = Math.min(res, now);
            // System.out.println(res + " " + now);
            now -= prime[nums[r-k+1]];
        }
        // System.out.println(sum + " " + res);
        
        System.out.println(sum - res);
    
    }

}


