package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC32_sol1 {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int pre = 0; // 前面的括号匹配长度，比如 ()(()) 中的 '()'
        int ans = 0;
        for(char c : s.toCharArray()){
            // 1. ...( 的情况，等待匹配；由于可能出现 (() 的情况，pre 在存储后要置 0
            if(c == '('){
                stack.push(pre);
                pre = 0;
                continue;
            }

            // 2. ...(...) 匹配
            if(!stack.isEmpty()){
                pre += stack.pop() + 2;
                ans = Math.max(ans, pre);
                continue;
            }

            // 3. ...) 多了 ')' 的情况，直接舍弃前面的匹配
            pre = 0;
        }
        return ans;
    }
}
