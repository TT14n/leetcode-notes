package tree;

public class LC124 {
    int ans = Integer.MIN_VALUE;

    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftSum = dfs(node.left);
        int rightSum = dfs(node.right);
        ans = Math.max(ans, leftSum + rightSum + node.val);
        // 选择最大的一个子树，或者都不选择
        return Math.max(Math.max(leftSum, rightSum) + node.val, 0);
    }
    public int maxPathSum(TreeNode root) {
        // 包含 node 节点的路径需要从：祖宗节点，左子树，右子树中三选二
        dfs(root);
        return ans;
    }
}
