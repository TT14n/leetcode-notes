package math;
public class LC1015 {

    public static void main(String[] args) {
        LC1015 solution = new LC1015();
        System.out.println(solution.smallestRepunitDivByK(7));   
    }

    public int smallestRepunitDivByK(int k) {
        int mod = 0;
        for(int i=1; i<=k; i++){
            mod = (mod * 10 + 1) % k; 
            if(mod == 0){
                return i;
            }
        }
        return -1;
        
    }
}