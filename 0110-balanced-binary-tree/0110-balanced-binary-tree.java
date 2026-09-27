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
    boolean isTrue=true;
    public boolean isBalanced(TreeNode root) {
        postorder(root);
        return isTrue;
    }
    public int postorder(TreeNode node){

       if(node==null )return 0;
       int left= postorder(node.left);
       int right=postorder(node.right);
        if(Math.abs(left-right)>1){
            isTrue=false;
        }
        int height=Math.max(left,right)+1;
        return height;
}
}