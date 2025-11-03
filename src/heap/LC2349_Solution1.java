package heap;

public class LC2349_Solution1 {
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public int subarrayGCD(int[] nums, int k) {
        // 滑动窗口
        int l = -1;
        int result = 0;
        for(int r=0; r<nums.length; r++){
            nums[r] = nums[r]%k==0 ? nums[r]/k : 0; // 缩小范围，只考虑k的倍数
            if (nums[r] == 0) { // 不是 k 的倍数
                l=r; // 左开右闭 (l, r]
                continue;
            }
            // 判断是否是最大的公因数
            boolean flag = false;
            for(int i=r; i>l; i--){
                if(gcd(nums[i], nums[r]) == 1){
                    flag = true;
                    break;
                }
            }
            if(flag) result += r-l-(nums[r]==1 ? 0 : 1);

            System.out.println(l + " " + r + " " + result);
        }
        return result;
    }

    public static void main(String[] args) {
        LC2349_Solution1 sol = new LC2349_Solution1();
        int[] nums = {4,3,1,3,3};
        System.out.println(sol.subarrayGCD(nums, 1));
    }
}

