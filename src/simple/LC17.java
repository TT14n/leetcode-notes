package simple;

import java.util.*;

public class LC17 {
    List<String> ans = new ArrayList<>();
    HashMap<Character, String> map = new HashMap<>();
    char[] record;
    public List<String> letterCombinations(String digits) {
        
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        char[] chars = digits.toCharArray();
        record = new char[chars.length];
        dfs(chars, 0, 'a');
        return ans;
    }

    void dfs(char[] chars, int depth, char choice){
        if(depth > 0){
            record[depth-1] = choice;
        }

        if(depth == chars.length){
            ans.add(new String(record));
            return;
        }

        for(char c : map.get(chars[depth]).toCharArray()){
            dfs(chars, depth+1, c);
        }
    
    }
}
