package simple;

public class LC717_sol1 {
    public static void main(String[] args) {
        
    }
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i;
        for(i=0; i<n-1; i++){
            if(bits[i] == 1){
                i++;
            }
        }
        return (i==n-1) ? true : false;  
    }
}
