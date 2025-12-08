package tree;

public class LC437 {
    long[] sum;
    int ans = 0;
    int targetSum;
    public int pathSum(TreeNode root, int targetSum) {
        sum = new long[1001];
        this.targetSum = targetSum;
        dfs(root, 1);
        return ans;
    }
    void dfs(TreeNode node, int depth){
        if(node == null){
            return;
        }


        sum[depth] = sum[depth-1] + node.val;
        for(int l=0; l<depth; l++){
            if(sum[depth] - sum[l] == targetSum){
                ans++;
            }
        }
        dfs(node.left, depth+1);
        dfs(node.right, depth+1);
        // sum[depth] = 0;
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