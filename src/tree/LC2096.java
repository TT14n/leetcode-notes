package tree;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

import javax.swing.tree.TreeNode;

public class LC2096 {
    public class TreeNode {
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
 
    private boolean findNode(TreeNode node, int val, Deque<Character> path){
        if(node == null){
            return false;
        }

        if(node.val == val){
            return true;
        }

        path.push('L');;
        boolean leftFlag = findNode(node.left, val, path);
        if(leftFlag == true){
            return true;
        }
        path.pop();

        path.push('R');
        boolean rightFlag = findNode(node.right, val, path);
        if(rightFlag == true){
            return true;
        }
        path.pop();

        return false;
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        Deque<Character> sPath = new ArrayDeque<>();
        Deque<Character> tPath = new ArrayDeque<>();

        findNode(root, startValue, sPath);
        findNode(root, destValue, tPath);
        
        StringBuilder sPart = new StringBuilder();
        StringBuilder tPart = new StringBuilder();
        for(char c : sPath){
            sPart.append(c);
        }
        for(char c : tPath){
            tPart.append(c);
        }
        sPart.reverse();
        tPart.reverse();
        int i;
        for(i=0; i<Math.min(sPart.length(), tPart.length()); i++){
            if(sPart.charAt(i) != tPart.charAt(i)){
                break;
            }
        }
        sPart = sPart.delete(0, i);
        tPart = tPart.delete(0, i);
        
        StringBuilder res = new StringBuilder();
        for(int j=0; j<sPart.length(); j++){
            res.append('U');
        }
        res.append(tPart);
        // sPart.append(tPart.reverse());
        return res.toString();

    }}
