package simple;

public class LC717_sol2 {
    public static void main(String[] args) {
        
    }
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i;
        // 找到前一个0的位置
        for(i=n-2; i>=0; i--){
            if(bits[i] == 0){
                break;
            }
        }
        // 1 的数目
        int cnt = n-2-i;
        return cnt % 2 == 0;

    }
}
