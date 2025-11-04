package simple;

public class LC1578 {
    int minCost(String colors, int[] neededTime){
        int result = 0;
        int l = 0;
        for(int r=1; r<colors.length(); r++){
            // 删除需要注意字符的移动
            // if (colors.charAt(i) == colors.charAt(i+1)){
            //     result += Math.min(neededTime[i], neededTime[i+1]);
            // }
            if (colors.charAt(l) == colors.charAt(r)){
                int min;
                if(neededTime[l] < neededTime[r]){
                    min = l;
                    l = r;
                }else{
                    min = r;
                }
                result += neededTime[min];
            }
            l = r;
        }
        return result;
    }

    public static void main(String[] args) {
        LC1578 solution = new LC1578();
        System.out.println(solution.minCost("aaabbbabbbb", new int[]{3,5,10,7,5,3,5,5,4,8,1}));
        
    }
}
