package tree;

public class LC104 {
    private  int maxDepth(TreeNode root) {
        return dfs(root);
    }

    int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(dfs(node.left), dfs(node.right)) + 1;
    }

    static class TreeNode {
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
}
