import java.util.List;

class Solution {
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
        Solution solution = new Solution();
        boolean result = solution.doesAliceWin("leetcoder");
        System.out.println(result);
    }
}