package greedy;
import java.util.Arrays;
import java.util.Comparator;

public class LC2141_sol2 {
    public static void main(String[] args) {
        LC2141_sol2 solution = new LC2141_sol2();
        System.out.println(solution.maxRunTime(2, new int[]{3,3,3}));
    }

    public long maxRunTime(int n, int[] batteries) {
        // 贪心方案
        // >= x 的电池，单独适配一个电脑（可以删除不予考虑，简化为 n'*x）
        // 因为 >= x 只算做 x，所以有 sum' >= n' * x
        // < x 的电池，sum'>=n'*x，所以电池数量 c > n'
        // 思想层面：可以将剩余的电池从大到小排，先考虑最大的 c 个电池，然后把剩余电池划分到这 c 个电池中
        // 这个过程可以一步步来思考，排 c+1 的电池可以被任意划分；然后把前 c+1 个电池视作一个整体，那么排 c+2 号电池就可以被任意划分 



        // 在 sol1 的基础上，我们只要做到，找到符合 sum'>=n'*x 中最大的 x 即可 
        // 我们对电池电量从大到小排序，然后从电量最大的电池开始遍历：

        // 1.若该电池电量超过 x，则将其供给一台电脑，问题缩减为 n−1 台电脑的子问题。
        // 2.若该电池电量不超过 x，则其余电池的电量均不超过 x

        Arrays.sort(batteries);
        long total = 0;
        for(int bat : batteries){
            total += bat;
        }
        for (int i = batteries.length - 1; ; i--) {
            if (batteries[i] <= total / n) {
                return total / n;
            }
            total -= batteries[i];
            n--;
        }
    }

}