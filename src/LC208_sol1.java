import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Trie {
    Set<String> pre;
    Set<String> words;
    public Trie() {
        pre = new HashSet<>();
        words = new HashSet<>();
    }
    
    public void insert(String word) {
        char[] chs = word.toCharArray();
        for(int i=1; i<chs.length; i++){
            pre.add(new String(chs, 0, i));
        }
        words.add(word);
    }
    
    public boolean search(String word) {
        return words.contains(word);
    }
    
    public boolean startsWith(String prefix) {
        return prefix.contains(prefix);
    }
}
