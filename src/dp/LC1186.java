package dp;
public class LC1186 {
    public static void main(String[] args) {
        LC1186 solution = new LC1186();
        System.out.println(solution.maximumSum(new int[]{1, -2, 0, 3}));
    }
    public int maximumSum(int[] arr) {
        int f0 = 0, len = 0, f1 = 0;
        int ans = arr[0];
        for(int i=0; i<arr.length; i++){
            int val = arr[i];
            // 不考删除情况
            if(f0 < 0){
                f0 = val;
                len = 1;
            }else{
                f0 += val;
                len++;
            }

            f1 += val; // f1 本身时已经删除过的子串，只能继续加
            if(len > 1){ // 考虑删除的情况 
                f1 = Math.max(f1, f0-val); // 不用考虑最小值，反正已经每个值都尝试删过了
            }
            ans = Math.max(ans, Math.max(f0, f1));
            // System.out.println(f0 + " " + f1 + " " + len) ;
        }
        return ans;
    }
}
