package KamaCoder.Issue095;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class No352 {
    private static int cnt = 1;
    private static int[][] direct = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] nums = new int[n][n];
        
        String[] parts;
        for(int i=0; i<n; i++){
            parts = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                nums[i][j] = Integer.parseInt(parts[j]);
            }
        }

        nums[0][0] = 1;
        dfs(nums, 0, 0);
        for(int i=0; i<n; i++){
            System.out.println(Arrays.toString(nums[i]));
        }
        bw.write(Integer.toString(n*n - cnt));
        bw.newLine();

        br.close();
        bw.close();
    }

    static void dfs(int[][] nums, int i, int j){
        for(int k=0; k<4; k++){
            int nxi = i + direct[k][0];
            int nxj = j + direct[k][1];
            if((nxi >= 0 && nxj >= 0 && nxi < nums.length && nxj < nums[0].length) && nums[nxi][nxj] == 0){
                nums[nxi][nxj] = 1;
                cnt++;
                // System.out.println(nxi + " " +  nxj);
                dfs(nums, nxi, nxj);
            }
        }
    }
}
