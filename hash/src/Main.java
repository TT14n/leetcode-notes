import java.lang.Math;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    private Set<String> vowels = Set.of("a", "e", "i", "o", "u");
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashMap<String, String> words = new HashMap<>();
        HashMap<String, String> ignoreCase = new HashMap<>();
        HashMap<String, String> ignoreVowel = new HashMap<>();
        for(String word : wordlist){
            if(!words.containsKey(word))words.put(word, word);
            String ignoreCaseKey = word.toLowerCase();
            if(!ignoreCase.containsKey(ignoreCaseKey))ignoreCase.put(ignoreCaseKey, word);
            String ignoreVowelKey = word.toLowerCase().replaceAll("[aeiou]", "#");
            if(!ignoreVowel.containsKey(ignoreVowelKey))ignoreVowel.put(ignoreVowelKey, word);
        }
//        for(Map.Entry<String, String> entry : words.entrySet()){
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
        String[] result = new String[queries.length];
        for(int i = 0; i < queries.length; i++){
            String query = queries[i];
            if (words.containsKey(query)){
                result[i] = words.get(query);
            }else if(ignoreCase.containsKey(query.toLowerCase())){
                result[i] = ignoreCase.get(query.toLowerCase());
            }else{
                result[i] = ignoreVowel.getOrDefault(query.toLowerCase().replaceAll("[aeiou]", "#"), "");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] result = sol.spellchecker(new String[]{"KiTe","kite","hare","Hare"}, new String[]{"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"});

    }
}