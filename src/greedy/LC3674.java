package greedy;

import java.util.List;

public class LC3674 {
    private static final List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
    public boolean doesAliceWin(String s) {
        // int count = 0;
        for(char c: s.toCharArray()){
            if(vowels.contains(c)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        LC3674 solution = new LC3674();
        boolean result = solution.doesAliceWin("leetcoder");
        System.out.println(result);
    }
}

