package dp;
public class LC1262_sol2 {
    public static void main(String[] args) {
        LC1262_sol2 solution = new LC1262_sol2();
        System.out.println(solution.maxSumDivThree(new int[]{2,6,2,2,7}));   
    }
    public int maxSumDivThree(int[] nums) {
        // 贪心 + 逆向思维
        // 看所有结果累加后的 mod3 值
        // mod3 == 0 则返回累加结果
        // mod3 == 1 则丢弃一个最小的 valm1 或者 两个最小的 valm2（valm1 valm2 表示 mod3 结果为1和2的值）
        // mod3 == 2 则丢弃一个最小的 valm2 或者 两个最小的 valm1（
        int sum = 0;
        int inf = 100_0000; 
        int firstMinm1=inf, secondMinm1=inf;
        int firstMinm2=inf, secondMinm2=inf;
        int modCnt = 0;

        for(int num : nums){
            sum += num;
            int mod = num % 3;
            modCnt += mod;
            if(mod==1){
                if(num < firstMinm1){
                    secondMinm1 = firstMinm1;
                    firstMinm1 = num;
                }else if(num < secondMinm1){
                    secondMinm1 = num;
                }
            }else if(mod==2){
                if(num < firstMinm2){
                    secondMinm2 = firstMinm2;
                    firstMinm2 = num;
                }else if(num < secondMinm2){
                    secondMinm2 = num;
                }
            }
        }

        
        modCnt %= 3;
        if(modCnt == 0){
            return sum;
        }

        int remove;
        if(modCnt == 1){
            remove = Math.min(firstMinm1, firstMinm2+secondMinm2);
        }else{
            remove = Math.min(firstMinm2, firstMinm1+secondMinm1);
        }
        // System.out.println(modCnt + " " + remove);
        // System.out.println(firstMinm1);
        // System.out.println(firstMinm2 + " " + secondMinm2);

        // 存在选不出来的情况
        return Math.max(0, sum - remove);
    }
}
