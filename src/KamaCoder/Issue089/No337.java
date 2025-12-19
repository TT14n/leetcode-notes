package KamaCoder.Issue089;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class No337 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] parts;
            parts = br.readLine().split(" ");
            int n = Integer.parseInt(parts[0]);
            int q = Integer.parseInt(parts[1]);
            int[] a = new int[n];
            parts = br.readLine().split(" ");
            

            // // 统一处理 i 之前的全 1 段
            // nums[0][0] = Integer.parseInt(parts[0]);
            // nums[0][1] = 0;
            for(int i=0; i<n; i++){
                a[i] = Integer.parseInt(parts[i]);
            }

            long[] f = new long[n+1];
            f[0] = 1;
            int MAX = 10_0000_0000;
            // 如果某个f(l, r) > 10 ^ 9，则小苯会直接舍弃此值，即将其视为0.
            int idx = 0; // 分隔非0段
            while(idx < n){
                if(a[idx] == 0){
                    idx++;
                    continue;
                }

                int start = idx;
                while (idx < n && a[idx] != 0) {
                    idx++;
                }

                int L = idx - start;
                // 检查是否全为 1 
                boolean allOne = true;
                for(int j=start; j<start+L; j++){
                    if(a[j] != 1){
                        allOne = false;
                        break;
                    }
                }
                if(allOne){
                    for(int len = 1; len<= L; len++){
                        f[len] += L - len + 1;
                    }
                    continue;
                }

                // 收集大于 1 的元素位置
                ArrayList<Integer> pos = new ArrayList<>();
                for(int j=start; j<start+L; j++){
                    if(a[j] > 1){
                        pos.add(j-start);
                    }
                }
                int k = pos.size();
                // 处理全 1 子段
                ArrayList<Integer> splits = new ArrayList<>();
                splits.add(-1);
                splits.addAll(pos);
                splits.add(L);
                for(int splitIdx = 0; splitIdx+1<splits.size(); splitIdx++){
                    // (l, r)
                    int l = splits.get(splitIdx) + 1;
                    int r = splits.get(splitIdx+1) - 1;
                    if(l <= r){
                        int L1 = r - l + 1;
                        for(int len=1; len<=L1; len++){
                            f[len] += L1 - len + 1;
                        }
                    }
                }

                // 处理包含大于 1 元素的子数组
                for(int i1=0; i1<k; i1++){
                    long M = 1L;
                    for(int j1=i1; j1<k; j1++){
                        M *= a[start + pos.get(j1)];
                        if(M > MAX){
                            break;
                        }

                        // 计算扩展范围
                        int A = (i1 == 0) ? 0 : (pos.get(i1-1) + 1);
                        int B = pos.get(i1);
                        int C = pos.get(j1);
                        int D = (j1==k-1) ? (L-1) : (pos.get(j1+1)-1);

                        int minlen = C - B + 1;
                        int maxlen = D - A + 1;
                        for(int length = minlen; length<=maxlen; length++){
                            int leftMin = Math.max(A, C-length+1);
                            int leftMax = Math.min(B, D-length+1);
                            if(leftMax >= leftMin){
                                int cnt = leftMax - leftMin + 1;
                                f[length] +=  M*cnt;
                            }
                        }
                    }
                }
            }

            while (q-- > 0) {
                int len = Integer.parseInt(br.readLine());
                bw.write(Long.toString(f[len]));
                bw.newLine();
            }
        }
        bw.close();
        br.close();
    
    }
}
