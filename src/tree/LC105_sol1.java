package tree;

public class LC105_sol1 {
    public static void main(String[] args) {
        // 通过 preorder 和 inorder 确定二叉树 
        LC105_sol1 solution = new LC105_sol1();
        System.out.println(solution.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }

    private int pos = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder 确定下一个节点
        // inorder 判断左右
        return dfs(preorder, inorder, 0, inorder.length-1);
    }

    TreeNode dfs(int[] preorder, int[] inorder, int l, int r){
        // System.out.println(pos + " " + l + " " + r);
        // 寻找当前 node 在 inorder 的位置
        if(pos == preorder.length){
            return null;
        }
        int mid;
        for(mid=l; mid<=r; mid++){
            if(inorder[mid] == preorder[pos]){
                break;
            }
        }
        
        TreeNode node = new TreeNode(preorder[pos++]);
        if(mid>l){
            node.left = dfs(preorder, inorder, l, mid-1);
        }

        if(mid<r){
            node.right = dfs(preorder, inorder, mid+1, r);
        }
        
        return node;
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
