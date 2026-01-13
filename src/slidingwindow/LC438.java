package slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class LC438 {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length()){
            return new ArrayList<>();
        }

        ArrayList<Integer> arr = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        for(int i=0; i<p.length(); i++){
            sCount[sChars[i] - 'a']++;
            pCount[pChars[i] - 'a']++;
        }
        
        if(equal(sCount, pCount)){
            arr.add(0);
        }

        for(int i=p.length(); i<s.length(); i++){
            sCount[sChars[i-p.length()] - 'a']--;
            sCount[sChars[i] - 'a']++;
            if(equal(sCount, pCount)){
                arr.add(i-p.length()+1);
            }
        }

        return arr;
        
    }
    
    private boolean equal(int[] sCount, int[] pCount) {
        for(int i=0; i<26; i++){
            if(sCount[i] != pCount[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
    }
}
