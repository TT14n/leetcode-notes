package dualpointer;
public class LC42 {
    public static void main(String[] args) {
        LC42 solution = new LC42();
        System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public int trap(int[] height) {
        int result = 0;
        int n= height.length;
        // 双指针，看起来是 dp 的再简化？还是考虑左右的 height
        int l=0, r=n-1;
        int leftHeight = height[l], rightHeight = height[r];
        while(l<=r){
            while(l<=r && leftHeight <= rightHeight){
                result += leftHeight - height[l];
                l++;
                if(l>r){
                    break;
                }
                leftHeight = Math.max(leftHeight, height[l]);
                // System.out.println(l + " " + r + " " + leftHeight + " " + rightHeight + " " + result);
            }

            while(l<=r && leftHeight > rightHeight){
                result += rightHeight - height[r];
                r--;
                if(l>r){
                    break;
                }
                rightHeight = Math.max(rightHeight, height[r]);
                // System.out.println(l + " " + r + " " + leftHeight + " " + rightHeight + " " + result);
            }
        }
        return result;
    }
}
