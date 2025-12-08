package tree;

public class LC230 {
    int k;
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        // 肯定需要每个节点都遍历一遍，但是需要考虑如何知道第K小
        this.k = k;
        dfs(root);
        return ans;
    }


    void dfs(TreeNode node){
        // LNR
        if(node == null){
            return;
        }

        dfs(node.left);
        k--;
        if(k == 0){
            ans = node.val;
        }
        dfs(node.right);
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
