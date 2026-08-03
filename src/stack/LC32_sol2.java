package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC32_sol2 {
    public int longestValidParentheses(String s) {
        int ans = 0;
        int left, right;
        char[] chars = s.toCharArray();
        int n = chars.length;
        // 扫描区间中的括号数量关系分为三种：
        // 1. left == right：左右括号数量相同；若扫描过程中没有出现非法前缀，则当前区间有效
        // 2. left > right：左括号过多，例如 "(()"、"()("
        // 3. left < right：右括号过多，例如 "())"、")()"

        // 从左往右扫可以覆盖：1,3 情况中的有效括号匹配状态
        left = 0;
        right = 0;
        for(int i=0; i<n; i++){
            char c = chars[i];
            if(c == '('){
                left++;
            }else{
                right++;
                if(left == right){
                    ans = Math.max(ans, left*2);
                }else if(right > left){
                    left = 0;
                    right = 0;
                }
            }
        }

        // 从右往左扫可以覆盖：1,2 情况中的有效括号匹配状态
        left = 0;
        right = 0;
        for(int i=n-1; i>=0; i--){
            char c = chars[i];
            if(c == ')'){
                right++;
            }else{
                left++;
                if(left == right){
                    ans = Math.max(ans, left*2);
                }else if(right < left){
                    left = 0;
                    right = 0;
                }
            }
        }
        return ans;
    }
}
