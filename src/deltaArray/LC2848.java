package deltaArray;
import java.util.List;

public class LC2848 {

    public static void main(String[] args) {
        
    }

    // 差分数组的运用
    public int numberOfPoints(List<List<Integer>> nums) {
        int n = 100;
        int[] deltaArray = new int[n+2];
        for(List<Integer> add : nums){
            int l = add.get(0);
            int r = add.get(1);
            deltaArray[l] += 1;
            deltaArray[r+1] -= 1;
        }
        int ans = 0;
        int sum = 0;
        for(int i=0; i<n+1; i++){
            sum += deltaArray[i];
            if(sum > 0){
                ans++;
            }
        }

        return ans;
    }

}