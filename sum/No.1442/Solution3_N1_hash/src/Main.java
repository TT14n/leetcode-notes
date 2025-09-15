import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int countTriplets(int[] arr) {
        // 后移一位，方便处理极值
        int[] xorArray = new int[arr.length+1];
        xorArray[0] = 0;
        for(int i=1; i<arr.length+1; i++){
            xorArray[i] = arr[i-1] ^ xorArray[i-1];
        }
        // k-i 转换为（k,i 可变），固定 k，则对于这个 k，产生的所有贡献为（此处的 k，i 均满足 xorArray[i-1] == xorArray[k]）
        // (k-i1) + (k-i2) + ... + (k-in) = k*n - (i1 + i2 + ... + in)
        // 因此只需要存储 i 的下标之和，和即可
        HashMap<Integer, Integer> xorIndexSum = new HashMap<>();
        HashMap<Integer, Integer> xorNumCount = new HashMap<>();
        // 因为 xorArray[i-1] == xorArray[k]，而存储的是 i 的下标之和，所以 i-1 要 +1，即存储的是 k+1
        int count = 0;
        for(int k=0; k<xorArray.length; k++){
            if(xorNumCount.containsKey(xorArray[k])){
                int n = xorNumCount.get(xorArray[k]);
                int indexSum = xorIndexSum.get(xorArray[k]);
                count += k*n - indexSum;
                xorIndexSum.put(xorArray[k], indexSum+k+1);
                xorNumCount.put(xorArray[k], n+1);
//                System.out.println(k + " " + xorArray[k] + " " + n + " " + indexSum);
            }else{
                xorIndexSum.put(xorArray[k], k+1);
                xorNumCount.put(xorArray[k], 1);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.countTriplets(new int[]{2, 3, 1, 6, 7});
        System.out.println(result);
    }
}
