/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode prev=null;
    int min=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;  
    }
    public void inorder(TreeNode node){
        if(node==null) return;
        inorder(node.left);
        if(prev!=null){
            int c_min=Math.abs(prev.val-node.val);
            if(c_min<min){
            min=c_min;
        }
        }
        prev=node;
        inorder(node.right);
    }
}