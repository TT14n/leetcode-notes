package simple;
public class LC41_sol1 {

    public static void main(String[] args) {
        
    }
    public int firstMissingPositive(int[] nums) {
        int maxNum = nums.length;
        int[] record = new int[maxNum+2];
        for(int num : nums){
            if(num <= 0 || num > maxNum){
                continue;
            }
            record[num] = 1; 
        }

        int i;
        for(i=1; i<= maxNum+1; i++){
            if(record[i] == 0){
                break;
            }
        }

        return i;

        
    }
}