import java.util.*;
class Solution {
    public String sortVowels(String s) {
        // 创建一个有序的 Map
        TreeMap<Character, Integer> vowelMap = new TreeMap<>();
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                vowelMap.put(c, vowelMap.getOrDefault(c, 0)+ 1);
            }
        }
//        for (Map.Entry<Character, Integer> entry : vowelMap.entrySet()){
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()){
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
                Map.Entry<Character, Integer> entry = vowelMap.firstEntry();
                if(entry.getValue() == 1){
                    vowelMap.remove(entry.getKey());
                }else{
                    vowelMap.put(entry.getKey(), entry.getValue() - 1);
                }
                sb.append(entry.getKey());
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.sortVowels("lEetcOde");  // 调用函数进行测试
        System.out.println(result);
    }
}
