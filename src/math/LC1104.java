package math;

import java.util.ArrayList;
import java.util.List;

public class LC1104 {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> result = new ArrayList<>();
        result.add(label);
        // 求 2 的幂
        int power = 1;
        while(label > Math.pow(2, power) - 1){
            power++;
        }
        // 奇偶性，求解2的幂可以通过位移操作简化
        int x = power % 2;
        if(x == 0) label = (int)Math.pow(2, power) - 1 - label + (int)Math.pow(2, power-1);

        while(label > 1){
            x ^= 1;
            power--;
            label /= 2;

            if(x==0){
                result.add((int)Math.pow(2, power) - 1 - label + (int)Math.pow(2, power-1));
            }else{
                result.add(label);
            }
        }
        result = result.reversed();
        return result;
    }

    public static void main(String[] args) {
        LC1104 sol = new LC1104();
        System.out.println(sol.pathInZigZagTree(14));
        System.out.println(sol.pathInZigZagTree(26));
    }
}

