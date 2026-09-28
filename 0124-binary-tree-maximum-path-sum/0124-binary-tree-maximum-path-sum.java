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
    int max_sum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        postorder(root);
        return max_sum;
    }
    public int   postorder(TreeNode node){
        if(node==null)return 0;
        int left = Math.max(0, postorder(node.left));
        int right = Math.max(0, postorder(node.right));
        int path=left+right+node.val;
        max_sum = Math.max(max_sum, path);
        return node.val + Math.max(left, right);
    }
}