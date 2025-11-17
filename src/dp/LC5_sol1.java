package dp;
public class LC5_sol1 {
    public static void main(String[] args) {
        LC5_sol1 solution = new LC5_sol1();
        System.out.println(solution.longestPalindrome("babad"));
        
    }
    public String longestPalindrome(String s) {
        // 多维dp
        int n = s.length();
        int ansSize = 1;
        int ansl = 0, ansr = 1;
        int[][] dp = new int[n+1][n+1];
        for(int size=0; size<=n; size++){ // 需要从小 size 开始枚举
            for(int l=0; l<n-size+1; l++){ // 枚举从 l 开始，到 r 结束的子串，是不是回文子串
                int r = l+size;
                if(size < 2){ // 长度为 0 和长度为 1 的子串一定是回文子串
                    dp[l][r] = 1;
                    continue;
                }
                if(s.charAt(r-1) == s.charAt(l)){
                    dp[l][r] |= dp[l+1][r-1]; 
                    if(dp[l][r] == 1 && size > ansSize){
                        ansSize = size;
                        ansl = l;
                        ansr = r;
                    }
                }
            }
        }
        return s.substring(ansl, ansr);
    }   
}   