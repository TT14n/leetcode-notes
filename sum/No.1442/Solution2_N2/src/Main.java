import java.util.Arrays;
class Solution {
    public int countTriplets(int[] arr) {
        // 两次异或可抵消
        int[] xorArray = new int[arr.length];
        xorArray[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            xorArray[i] = arr[i] ^ xorArray[i-1];
//            System.out.println(xorArray[i] + " " + arr[i] + " " + xorArray[i-1]);
        }
        int count = 0;
        for(int i=0; i<xorArray.length; i++){
            for(int k=i+1; k<xorArray.length; k++) {
                if (i == 0 ? xorArray[k] == 0 : xorArray[i - 1] == xorArray[k]) {
                    count+=k-i;
                }
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
