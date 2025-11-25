package simple;

public class LC1145 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
        }
    }

    TreeNode findNode(TreeNode node, int x){
        if(node == null){
            return null;
        }
        if(node.val == x){
            return node;
        }
        TreeNode lres = findNode(node.left, x);
        if(lres != null){
            return lres; 
        }
        TreeNode rres = findNode(node.right, x);
        if(rres != null){
            return rres; 
        }
        return null;
    }

    int cntNodes(TreeNode node){
        if(node == null){
            return 0;
        }

        if(node.left == null && node.right == null){
            return 1;
        }

        return cntNodes(node.left) + cntNodes(node.right) + 1;
    }

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        // 找到 x 节点
        // 统计其 左子树，右子树 的节点数目
        // 通过计算得出父节点能涂色的节点数目
        int lnodes = 0, rnodes = 0;
        TreeNode xNode = findNode(root, x);
        lnodes = cntNodes(xNode.left);
        rnodes = cntNodes(xNode.right);
        int remain = n - lnodes - rnodes - 1;
        // System.out.println(remain + " " + lnodes + " " + rnodes);
        int maxPart = Math.max(remain, Math.max(lnodes, rnodes));
        if(maxPart > n - maxPart){
            return true;
        }else{
            return false;
        }
    }
}
