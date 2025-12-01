package greedy;
public class LC2141_sol1 {
    public static void main(String[] args) {
        LC2141_sol1 solution = new LC2141_sol1();
        System.out.println(solution.maxRunTime(2, new int[]{3,3,3}));
    }

    public long maxRunTime(int n, int[] batteries) {
        // 二分答案
        long total = 0;
        for(int bat : batteries){
            total += bat;
        }

        long l = 1, r = total/n;
        while (l<r) {
            long mid = (l+r+1)/2;
            if(check(n, batteries, mid)){
                l = mid;
            }else{
                r = mid - 1;
            }
        } 

        return l;
        
    }

    public boolean check(int n, int[] batteries, long x){
        // 贪心方案
        // >= x 的电池，单独适配一个电脑（可以删除不予考虑，简化为 n'*x）
        // 因为 >= x 只算做 x，所以有 sum' >= n' * x
        // < x 的电池，sum'>=n'*x，所以电池数量 c > n'
        // 思想层面：可以将剩余的电池从大到小排，先考虑最大的 c 个电池，然后把剩余电池划分到这 c 个电池中
        // 这个过程可以一步步来思考，排 c+1 的电池可以被任意划分；然后把前 c+1 个电池视作一个整体，那么排 c+2 号电池就可以被任意划分 
        long sum = 0;
        for(int bat : batteries){
            sum += Math.min(bat, x);
        }
        return sum >= n*x;
    }
    
}