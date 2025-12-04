package greedy;

public class LC2211 {
    public static void main(String[] args) {
        LC2211 solution = new LC2211();
        System.out.println(solution.countCollisions("SRRLRLRSRLRSSRRLSLRLLRSLSLLSSRRLSRSLSLRRS"));
    }
    
    public int countCollisions(String directions) {
        int ans = 0;
        int right = 0;
        boolean pre = false; // 前面是否有S的车
        for(char c : directions.toCharArray()){
            if(c == 'S'){
                pre = true;
                if(right > 0){
                    ans += right;
                    right = 0;
                }
            }else if(c == 'R'){
                right++;
            }else{
                if(right > 0){
                    ans += right + 1;
                    right = 0;
                    pre = true;
                }else if(pre){
                    ans++;
                }

            }
            // System.out.println(c + " " + ans);
        }

        return ans;
    }

}
