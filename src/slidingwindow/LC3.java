package slidingwindow;
import java.util.HashMap;

public class LC3 {
    public static void main(String[] args) {
        LC3 solution = new LC3();
        System.out.println(solution.lengthOfLongestSubstring("bbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        // 滑动窗口
        HashMap<Character, Integer> map = new HashMap<>();
        int r=0;
        int result = 0;
        char c;
        for(int l=0; l<s.length(); l++){
            while(r<s.length() && map.getOrDefault(s.charAt(r), 0) == 0){
                c = s.charAt(r);
                map.put(c, map.getOrDefault(c, 0) + 1);
                result = Math.max(result, r-l+1);
                r++;
            }
            c = s.charAt(l);
            map.put(c, map.get(c)-1);
        }

        return result;
    }

}
