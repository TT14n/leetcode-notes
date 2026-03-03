package KamaCoder.Issue097;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No357 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] parts = br.readLine().split(" ");

        // 区间 dp
        int[] nums = new int[n+2];
        int[][] dp = new int[n+2][n+2];
        for(int i=1; i<=n; i++){
            nums[i] = Integer.parseInt(parts[i-1]);    
        }
        
        // 处理边界
        nums[0] = 1;
        nums[n+1] = 1;
        
        // 反向思考，简化问题难度
        // 考虑最后选择的牌是什么？选择什么样的牌是最优解，然后一步步递推
        // 长度从 1 到 n 递推，不断深化问题
        for(int len=1; len<=n; len++){
            // 枚举区间
            for(int l=1; l<=n-len+1; l++){
                int r = l+len-1;
                // 假设最后选择的牌是第 k 张牌 
                for(int k=l; k<=r; k++){
                    dp[l][r] = Math.max(dp[l][r], dp[l][k-1] + dp[k+1][r] + nums[l-1] * nums[r+1]);
                }
            }
        }


        bw.write(Integer.toString(dp[1][n]));
        bw.newLine();

        br.close();
        bw.close();


    }
}
