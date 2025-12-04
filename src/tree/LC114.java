package tree;

public class LC114 {
    public void flatten(TreeNode root) {
        // 先序遍历
        dfs(root, null);
    }

    TreeNode dfs(TreeNode node, TreeNode pre){
        if(node == null){
            return pre;
        }

        TreeNode res;
        res = dfs(node.left, node);
        res = dfs(node.right, res);

        if(pre != null){
            pre.right = pre.left;
            pre.left = null;
        }
        return res;
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
}
