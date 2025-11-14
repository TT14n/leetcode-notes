package dp;
public class LC42 {
    public static void main(String[] args) {
        LC42 solution = new LC42();
        System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public int trap(int[] height) {
        int result = 0;
        int n= height.length;
        int[] leftHeight = new int[n];
        int[] rightHeight = new int[n];
        // dp，按照每个格子的角度的思考，考虑这个格子的水能蔓延到哪里？
        // 从而求解左右两个 height
        leftHeight[0] = height[0];
        for(int i=1; i<n; i++){
            leftHeight[i] = Math.max(leftHeight[i-1], height[i]);
        }

        rightHeight[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            rightHeight[i] = Math.max(rightHeight[i+1], height[i]);
        }

        for(int i=0; i<n; i++){
            result +=  Math.min(leftHeight[i], rightHeight[i]) - height[i]; 
        }
        
        return result;
    }
}
