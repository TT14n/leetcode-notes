package math;
import java.util.List;
import java.util.ArrayList;

public class LC3315 {
    public static void main(String[] args) {
        LC3315 solution = new LC3315();
        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(3);
        nums.add(5);
        nums.add(7);
        int[] res = solution.minBitwiseArray(nums);
        for(int i=0; i<res.length; i++){
            System.out.print(res[i] + " ");
        }
         
    }
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] res = new int[nums.size()];
        for(int i=0; i<nums.size(); i++){
            int x = nums.get(i);
            if(x == 2){
                res[i] = -1;
            }else{
                // 找到第一个 0 的位置
                int zeroBit = ~x & -(~x);
                int highBits = x & ~(zeroBit-1); // 低位清空
                res[i] = highBits | ((zeroBit >> 1) - 1);
            }
        }
        return res;
    }
}
