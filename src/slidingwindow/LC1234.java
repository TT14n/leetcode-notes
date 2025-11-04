package slidingwindow;

import java.util.HashMap;

public class LC1234 {
    private boolean check(int[] count, int[] require){
        for(int i=0; i<4; i++){
            if(count[i] < require[i]) return false;
        }
        return true;
    }
    public int balancedString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('Q', 0);
        map.put('W', 1);
        map.put('E', 2);
        map.put('R', 3);

        int[] require = new int[4];
        int n = s.length();
        for(char c: s.toCharArray()){
            require[map.get(c)]++;
        }
        for(int i=0; i<4; i++){
            require[i] = require[i] - n/4;
        }


        int[] count = new int[4];
        if (check(count, require)) return 0;

        // 滑动窗口
        int l=0;
        int ans=n;
        for(int r=0; r<n; r++){
            count[map.get(s.charAt(r))]++;
            while(check(count, require)){
                ans = Math.min(ans, r-l+1);
                count[map.get(s.charAt(l))]--;
                l++;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        LC1234 sol = new LC1234();
        String s = "QWER";
        System.out.println(sol.balancedString(s));
    }
}







