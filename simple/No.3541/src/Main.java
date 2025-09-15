import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    private static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
    public int maxFreqSum(String s) {
        int maxVowel = 0;
        int maxConsonant = 0;
        HashMap<Character, Integer> vowelMap = new HashMap<>();
        HashMap<Character, Integer> consonantMap = new HashMap<>();
        int count;
        for(char c : s.toCharArray()){
            if(vowels.contains(c)){
                count = vowelMap.getOrDefault(c, 0)+1;
                maxVowel = Math.max(maxVowel, count);
                vowelMap.put(c, count);
            }else{
                count = consonantMap.getOrDefault(c, 0)+1;
                maxConsonant = Math.max(maxConsonant, count);
                consonantMap.put(c, count);
            }
        }
        return maxVowel + maxConsonant;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.maxFreqSum("successes");
        System.out.println(result);
    }
}