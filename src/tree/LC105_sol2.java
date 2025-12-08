package tree;

import java.util.HashMap;
import java.util.Map;
public class LC105_sol2 {
    public static void main(String[] args) {
        // 通过 preorder 和 inorder 确定二叉树 
        LC105_sol2 solution = new LC105_sol2();
        System.out.println(solution.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }

    private int pos = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder 确定下一个节点
        // inorder 判断左右
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return dfs(preorder, map, 0, inorder.length-1);
    }

    TreeNode dfs(int[] preorder, Map<Integer, Integer> map, int l, int r){
        // System.out.println(pos + " " + l + " " + r);
        // 寻找当前 node 在 inorder 的位置
        if(pos == preorder.length){
            return null;
        }
        int val = preorder[pos++];
        int mid = map.get(val);
        
        TreeNode node = new TreeNode(val);
        if(l < mid){
            node.left = dfs(preorder, map, l, mid-1);
        }
        if(r > mid){
            node.right = dfs(preorder, map, mid+1, r); 
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
