package tree;
import java.util.*;

public class LC199 {
    public static void main(String[] args) {
        
    }
    private List<Integer> arr = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        // 每一层的最右节点
        // NRL 遍历
        dfs(1, root);
        return arr;
    }

    void dfs(int depth, TreeNode node){
        if(node == null){
            return;
        }
        if(depth > arr.size()){
            arr.add(node.val);
        } 
        dfs(depth+1, node.right);
        dfs(depth+1, node.left);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
