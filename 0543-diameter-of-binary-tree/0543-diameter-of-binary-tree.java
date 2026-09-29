/**chrome-extension://debbebdlpbnpnnicofdpociejpmokdnm/resources/icon.png$0
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
    int max_D=Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
       postorder(root);
       return max_D; 
    }
    private int  postorder(TreeNode node){
        if(node==null) return 0;
        int left=postorder(node.left);
        int right=postorder(node.right);
        int current_D=left+right;
        if(max_D<current_D){
            max_D=current_D;
        }
        return Math.max(right,left)+1;
    }
}