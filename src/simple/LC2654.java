package simple;
public class LC2654 {

    public static void main(String[] args) {
        LC2654 solution = new LC2654();
        System.out.println(solution.maxOperations("1001101"));
    }

    public int maxOperations(String s) {
        int result = 0;
        int item = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1'){
                if(i-1 >= 0 && s.charAt(i-1)=='0'){
                    // System.out.println(i + " " + item + " " + result);
                    result += item;
                }
                item ++;
            }
        }
        if(s.charAt(s.length()-1) == '0'){
            result += item;
        }
        return result;
    }
}