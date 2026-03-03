package KamaCoder.Issue096;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No355_sol2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 输入
        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][n];
        for(int i=0; i<n; i++){
            String[] parts = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                matrix[i][j] = Integer.parseInt(parts[j]);
            }
        }

        // 矩阵转换为序列
        int[] array = new int[n*n];
        int top = 0, bottom = n-1, left = 0, right = n-1;
        int idx = 0;
        while(idx < n*n){
            // 向右走
            for(int i=left; i<=right && idx<n*n; i++){
                array[idx++] = matrix[top][i]; 
            }
            top++;
            for(int i=top; i<=bottom && idx<n*n; i++){
                array[idx++] = matrix[i][right];
            }
            right--;
            for(int i=right; i>=left && idx<n*n; i--){
                array[idx++] = matrix[bottom][i];
            }
            bottom--;
            for(int i=bottom; i>=top && idx<n*n; i--){
                array[idx++] = matrix[i][left];
            }
            left++;
        }

        // 方法二：使用归并排序求逆序对 
        int MOD = 10_0000_0007;
        int ans = mergeCount(array, 0, n*n-1, MOD);

        bw.write(Integer.toString(ans));

        br.close();
        bw.close();
    }

    static int mergeCount(int[] nums, int l, int r, int mod){
        long cnt = 0;
        if(l == r){ 
            return 0;
        }

        int mid = (l + r) / 2;
        cnt += mergeCount(nums, l, mid, mod);
        cnt += mergeCount(nums, mid+1, r, mod);

        int p = l, q = mid+1;
        int[] tmp = new int[r-l+1];
        int idx = 0;
        while (p <= mid && q <= r) {
            if(nums[p] > nums[q]){ // p 及其后面的数字都比 nums[q] 大
                cnt += mid - p + 1;
                tmp[idx++] = nums[q++];
            }else{
                tmp[idx++] = nums[p++];
            }   
        }

        while (p <= mid) {
            tmp[idx++] = nums[p++];
        }
        while (q <= r) {
            tmp[idx++] = nums[q++];
        }

        for(int i=0; i<idx; i++){
            nums[l+i] = tmp[i];
        }

        cnt = cnt % mod;
        return (int)cnt;

    }
}
