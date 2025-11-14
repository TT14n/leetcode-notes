package simple;
class LC2384 {
    public static void main(String[] args) {
        LC2384 solution = new LC2384();
        System.out.println(solution.largestPalindromic("444947137"));
    }
    public String largestPalindromic(String num) {
        int[] numCnt = new int[10];
        for(char c : num.toCharArray()){
            numCnt[c-'0']++;
        }
        // 偶数
        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--){
            for(int j=0; j<numCnt[i]/2; j++){
                if(i!=0 || sb.length()>0){
                    // 避免前导 0
                    sb.append(i);
                }
            }
        }
        // 奇数
        int mid = -1;
        for(int i=9; i>=0; i--){
            if(numCnt[i]%2 == 1){
                mid = i;
                break;
            }
        }
        // System.out.println(sb);
        StringBuilder rev = new StringBuilder();
        rev.append(sb);
        rev.reverse();

        if(mid != -1){
            sb.append(mid);
        }
        sb.append(rev);
        
        if(sb.length() == 0 && numCnt[0] > 0){
            return "0";
        }
        return sb.toString();
    }
}