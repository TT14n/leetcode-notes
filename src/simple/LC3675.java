package simple;

import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
public class LC3675 {
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
        LC3675 sol = new LC3675();
        String s = "yz";
        System.out.println(sol.minOperations(s));
    }
}

