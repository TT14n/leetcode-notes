package math;
import java.util.HashMap;

public class LC3623 {
    public static void main(String[] args) {
        LC3623 solution = new LC3623();
        System.out.println(solution.countTrapezoids(new int[][]{{1,0},{2,0},{3,0},{2,2},{3,2}}));
        
    }

    public int countTrapezoids(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int[] point : points){
            int y = point[1];
            map.put(y, map.getOrDefault(y, 0)+1);
        }

        long sum = 0;
        long count = 0;
        int mod = 10_0000_0000 + 7;
        for(int key : map.keySet()){
            long val = map.get(key);
            long comb = (val * (val-1) / 2) % mod; // 两两组合 
            count = (count + sum * comb % mod) % mod; // 行与行之间的组合
            // System.out.println(key + " " + comb + " " + sum);
            sum = (sum + comb) % mod;
        }
        return (int)count;
    }
}
