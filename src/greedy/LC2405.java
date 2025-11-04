package greedy;

import java.util.HashMap;
import java.util.Map;
public class LC2405 {
    public int partitionString(String s) {
        int result = 0;
        int remain = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                result++;
                remain = 1;
                // 清空map
                map.clear();
            }else{
                remain++;
            }
            map.put(c, 1);
        }
        
        if(remain>0){
            result++;
        }    

        return result;
        
    }
    public static void main(String[] args) {
        LC2405 solution = new LC2405();
        System.out.println(solution.partitionString("abacaba"));
    }
}
