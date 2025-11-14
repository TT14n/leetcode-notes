package dualpointer;
public class LC11 {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int result = (r-l)*Math.min(height[l], height[r]);
        while(l < r){  
            while(l < r && height[l] <= height[r]){
                l++;
                result = Math.max(result, (r-l)*Math.min(height[l], height[r]));
            }
            while(l < r && height[l] > height[r]){
                r--;
                result = Math.max(result, (r-l)*Math.min(height[l], height[r]));
            }
        }
        return result; 
    }
    public static void main(String[] args) {
        LC11 solution = new LC11();
        System.out.println(solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
