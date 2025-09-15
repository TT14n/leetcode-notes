import java.lang.Math;

class Solution {
    private int countBit(long x){
        int bits = 0;
        if (x==0) return 1;
        while(x!=0){
            x >>= 1;
            bits++;
        }
        return bits;
    }
    private long reverseBits(long x){
        long reverse = 0;
        while(x!=0){
            reverse <<= 1;
            // 取x的低位
            reverse |= x & 1;
            x >>= 1;
        }
        return reverse;
    }
    public int countBinaryPalindromes(long n) {
        if(n==0) return 1;
        int bits = countBit(n);
        long count = 0;
        // 位数n少的直接全部累加
        for(int i=0; i<bits-1; i++){
            count += (int)Math.pow(2, i/2);
//            System.out.println(count);
        }
        // 判断同位的
        int mid = bits/2;
        long left = n >> mid; // 奇数时，中间位不需要考虑右半部分，左半部分能枚举即可
        // 当左半>右半，就可以作为右半部分的借位
        // 这个地方相当于枚举 1000 ~ 1xxx，从 0 开始，所以虽然不包含 1xxx，但是数量是 xxx
        count +=  left & ((1L<<(bits%2==0 ? mid-1 : mid))-1);

        // 当左半就是当前n的左半，不能借位
        long right = reverseBits(left>> (bits%2==1 ? 1 : 0));
        if ((((left<<mid) | right ))<= n) count++;

        // 补充0的结果
        return (int)(count+1);
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        long result = sol.countBinaryPalindromes(9);
        System.out.println(result);
    }
}