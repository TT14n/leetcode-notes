package simple;
public class LC1930 {
    public static void main(String[] args) {
        LC1930 solution = new LC1930();
        System.out.println(solution.countPalindromicSubsequence("bbcbaba"));
        
    }
    public int countPalindromicSubsequence(String s) {
        // 长度为 3 的回文子串，可以视作在找相同字符
        // 判断是否重复，可以通过判断 hash 值（可以用 HashMap，或是手写（因为是小写字母，且前后字母相同，总共26*26种结果，））

        // 如何避免重复的判断？
        // 双指针，只需要找前后最大区间范围的相同字母，这样只需要 26*n 的结果

        int[] cnt = new int[26];
        for(char c : s.toCharArray()){
            cnt[c-'a'] ++;
        }

        int ans=0;
        for(char c1='a'; c1<='z'; c1++){
            if(cnt[c1-'a'] < 2){
                continue;
            }
            int[] appear = new int[26];
            int l=0, r=s.length()-1;
            while(l<r && s.charAt(l)!=c1) l++;
            while(l<r && s.charAt(r)!=c1) r--;
            for(int i=l+1; i<r; i++){
                if(appear[s.charAt(i)-'a'] == 0){
                    appear[s.charAt(i)-'a'] = 1;
                    ans++;
                }
            }
        }
        return ans;
    }
}
