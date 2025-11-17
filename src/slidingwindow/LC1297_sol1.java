package slidingwindow;
import java.util.HashMap;

public class LC1297_sol1 {
    public static void main(String[] args) {
        LC1297_sol1 solution = new LC1297_sol1();
        System.out.println(solution.maxFreq("abcde", 2, 3, 3));
        
    }
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        // hash
        HashMap<String, Integer> hash = new HashMap<>();
        int[] cntLetters = new int[26];
        int diifLetters = 0;
        for(int l=minSize; l<=maxSize; l++){
            for(int i=0; i<l; i++){
                int charIdx = s.charAt(i) - 'a';
                if(cntLetters[charIdx] == 0){
                    diifLetters++;
                }
                cntLetters[charIdx] ++;
            }
            String key = s.substring(0, l);
            if(diifLetters <= maxLetters){
                hash.put(key, 1);
            }

            for(int i=l; i<s.length(); i++){
                int charIdx = s.charAt(i) - 'a';
                if(cntLetters[charIdx] == 0){
                    diifLetters++;
                }
                cntLetters[charIdx] ++;

                int oldCharIdx = s.charAt(i-l) - 'a';
                cntLetters[oldCharIdx] --;
                if(cntLetters[oldCharIdx] == 0){
                    diifLetters--;
                } 

                if(diifLetters <= maxLetters){
                    key = s.substring(i-l+1, i+1);
                    System.out.println(key);
                    hash.put(key, hash.getOrDefault(key, 0) + 1);
                }
            }
        }

        int res = 0;
        for(HashMap.Entry<String, Integer> entry : hash.entrySet()){
            res = Math.max(res, entry.getValue());
        }

        return res;
    }
}
