package dp;
public class LC5_sol2 {
    class Solution {
        private int n;
        private int ansSize, ansl, ansr;
        private void expand(String s, int l, int r){
            while(l>=0 && r<n){
                if(s.charAt(l) != s.charAt(r)){
                    break;
                }
    
                int len = r-l+1;
                if(len > ansSize){
                    ansSize = len;
                    ansl = l;
                    ansr = r;
                }
                l--;
                r++;
            }
        }
        public String longestPalindrome(String s) {
            // 枚举回文中心，感觉对于回文子串来说，这个方法是最好的
            n = s.length();
            ansSize = 1;
            ansl = 0;
            ansr = 0;
            for(int center=0; center<n; center++){
                expand(s, center, center);
                expand(s, center, center+1);
            }
            return s.substring(ansl, ansr+1);
        }   
    }   
}
