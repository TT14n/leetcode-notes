package simple;
import java.util.HashMap;

public class LC3531 {

    public static void main(String[] args) {
        
    }

    public int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer, Integer> up = new HashMap<>();
        HashMap<Integer, Integer> down = new HashMap<>();
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        for(int[] building : buildings){
            int x = building[0], y = building[1];
            up.merge(x, y, Math::max); 
            down.merge(x, y, Math::min); 
            left.merge(y, x, Math::min); 
            right.merge(y, x, Math::max); 
        }

        int ans = 0;
        for(int[] building : buildings){
            int x = building[0], y = building[1];
            if(x > left.getOrDefault(y, n) && 
                x < right.getOrDefault(y, 0) &&
                y > down.getOrDefault(x, n) &&
                y < up.getOrDefault(x, 0)
            ){
                ans++;
            }
        }
               
        return ans;
    }
}