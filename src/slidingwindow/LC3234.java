package slidingwindow;
public class LC3234 {
    public static void main(String[] args) {
        LC3234 solution = new LC3234();
        System.out.println(solution.numberOfSubstrings("101101"));
         
        
    }
    public int numberOfSubstrings(String s) {
        // 统计 0 的位置
        int n = s.length();
        int[] zeroPos = new int[n+1];
        zeroPos[0] = -1;
        int zeroSize = 1;
        int oneSize = 0;
        int ans = 0;
        // 遍历 0 的个数，因为 字符串中 1 的数量 大于或等于 0 的数量的 平方
        // 故遍历的上限是 Math.min(zeroSize, Math.sqrt(oneSize))
        for(int r=0; r<n; r++){ // r的下标
            if(s.charAt(r) == '0'){
                zeroPos[zeroSize++] = r;
            }else{
                oneSize ++;
                ans += r - zeroPos[zeroSize-1];
            }
            for(int i = zeroSize-1; i>0 && (zeroSize-i) * (zeroSize-i) <= oneSize; i--){
                int p = zeroPos[i-1];
                int q = zeroPos[i];
                // if(q>r) continue;
                int cnt0 = zeroSize-i;
                int cnt1 = r - q + 1 - cnt0;
                ans += Math.max(q - p - Math.max(0, cnt0*cnt0 - cnt1), 0);
            }
        }

        return ans;
    }
}
