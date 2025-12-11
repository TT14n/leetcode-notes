package sum;
import java.util.HashMap;

public class LC3583_sol1 {
    public static void main(String[] args) {
         LC3583_sol1 solution = new LC3583_sol1();
         System.out.println(solution.specialTriplets(new int[]{22,90,11,22,44,88}));
    }
    public int specialTriplets(int[] nums) {
        // 使用 map
        // 0 存储 *2 时有多少数字
        // 1 存储到现在为止有多少重复数字
        HashMap<Integer, int[]> map = new HashMap<>();
        int ans = 0;
        int mod = 10_0000_0000 + 7;
        int[] defalut = new int[]{0,0};
        for(int num : nums){
            if(num % 2 == 0){
                ans = ( ans + map.getOrDefault(num/2, defalut)[0]) % mod;
            }

            int[] vals = map.getOrDefault(num, new int[]{0, 0});
            vals[0] = (vals[0] + map.getOrDefault(num*2, defalut)[1]) % mod;
            vals[1]++;
            map.put(num, vals);
            // System.out.println(num + " " + vals[0] + " " + vals[1] + " " + ans);
        }

        return ans;
    }
}
