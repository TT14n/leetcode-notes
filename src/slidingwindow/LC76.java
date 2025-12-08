package slidingwindow;
public class LC76 {
    public static void main(String[] args) {
        LC76 solution = new LC76();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));   
    }

    public String minWindow(String s, String t) {
        int[] need = new int[128];
        int diff = 0;
        for(char c : t.toCharArray()){
            int val = c-'A';
            if(need[val] == 0){
                diff++;
            }
            need[val]++;
        }

        int l = 0;
        int n = s.length();
        int ans = -1, ansl = 0, ansr = 0;
        int acc = 0;
        char[] chars = s.toCharArray();
        for(int r=0; r<n; r++){
            int val = chars[r] - 'A';
            need[val]--;
            if(need[val] == 0){
                acc++;
            }
            
            if(acc == diff){
                while(l < n){
                    val = chars[l] - 'A';
                    if(need[val] < 0){
                        need[val]++;
                        l++;
                    }else{
                        break;
                    }
                }

                if(ans == -1 || r-l+1 < ans){
                    ans = r - l + 1;
                    ansl = l;
                    ansr = r;
                }
            }

        }
        if(ans == -1){
            return "";
        }else{
            return s.substring(ansl, ansr+1);
        }
    }
}
