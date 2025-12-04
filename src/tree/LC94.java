package tree;

import java.util.ArrayList;
import java.util.List;

public class LC94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<Integer>();
        dfs(root, arr);
        return arr;
    }
    void dfs(TreeNode node, List<Integer> arr){
        if(node == null){
            return;
        }
        dfs(node.left, arr);
        arr.add(node.val);
        dfs(node.right, arr);
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
