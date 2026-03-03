package KamaCoder.Issue096;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


class FenwickTree{
    int[] tree;
    int n;

    public FenwickTree(int n){
        this.n = n;
        this.tree = new int[n+1];
    }

    // 前缀和查询：查询 [1, i] 范围内数字出现的总次数
    int query(int i){
        int cnt = 0;
        while (i > 0) {
            cnt += tree[i];
            i -= i & (-i);
        }
        return cnt;
    }

    // 单点更新：将位置 i 的计数 + delta
    void update(int i, int delta){
        while (i <= n) {
            tree[i] += delta;
            i += i & (-i);
        }
    }
}

public class No355_sol1 {
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
        

        // System.out.println(Arrays.toString(array));
        
       

        // 方法一：使用树状数组求逆序对 
        int ans = 0;
        FenwickTree tree = new FenwickTree(n*n);
        int MOD = 10_0000_0007;
    
        for(int l=n*n-1; l>=0; l--){
            // 在 > l 的位置，查找 < array[l] 的数目
            int cnt = tree.query(array[l]-1);
            ans = (ans + cnt) % MOD;
            tree.update(array[l], 1);
        }        

        bw.write(Integer.toString(ans));

        br.close();
        bw.close();


    }
}
