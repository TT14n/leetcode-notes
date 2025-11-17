package simple;
public class LC1513 {

    public static void main(String[] args) {
        LC1513 solution =new LC1513();
        System.out.println(solution.numSub("011011"));
    }
    public int numSub(String s) {
        int ans = 0;
        int mod = 10_0000_0000 + 7;
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1'){
                cnt++;
                ans = (ans + cnt) % mod; 
            }else{
                cnt = 0;
            }   
        }
        return ans;
    }
}