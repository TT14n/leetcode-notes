import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
class Solution {
    public int minOperations(String s) {
        char ch = 'b';
        while (ch <= 'z'){
            if (s.indexOf(ch) != -1){
                break;
            }
            ch++;
        }
        return ('a' - ch + 26) % 26;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "yz";
        System.out.println(sol.minOperations(s));
    }
}