package search;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC22 {

    public static void main(String[] args) {
        LC22 solution = new LC22();
        System.out.println(solution.generateParenthesis(3));
    }

    private List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        char[] chars = new char[n*2];
        dfs(0, 0, n, chars);
        return result;
    }

    public void dfs(int left, int right, int n, char[] chars){
        if(left == n && right == n){
            result.add(new String(chars));
            return;
        }
        // 枚举左括号'('
        if(left < n){
            chars[left+right] = '(';
            dfs(left+1, right, n, chars);
        }

        // 枚举右括号')'
        if(right < left){
            chars[left+right] = ')';
            dfs(left, right+1, n, chars);
        }

    }
}
