package sum;

public class LC1442_Solution1 {
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
            for(int j=i+1; j<xorArray.length; j++){
                for(int k=j; k<xorArray.length; k++){
                    int a = i==0 ? xorArray[j-1] : xorArray[j-1] ^ xorArray[i-1];
                    int b = j==k ? arr[j] : xorArray[k] ^ xorArray[j-1];
//                    System.out.println(i + " " + j + " " + k + " " +a + " " + b);
                    if (a == b){
                        count++;
                    }
                }
            }
        }

        return count;
    }
    public static void main(String[] args) {
        LC1442_Solution1 solution = new LC1442_Solution1();
        int result = solution.countTriplets(new int[]{2, 3, 1, 6, 7});
        System.out.println(result);
    }
}

