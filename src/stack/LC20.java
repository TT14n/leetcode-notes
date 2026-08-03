package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC20 {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if((top == '(' && c == ')') || (top == '[' && c == ']') || (top == '{' && c == '}')){
                    continue;
                }
                return false;
            }

        }
        return stack.isEmpty();
    }
}
