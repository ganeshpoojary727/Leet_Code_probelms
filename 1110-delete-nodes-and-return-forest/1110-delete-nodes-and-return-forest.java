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
    Set<Integer> delete_set=new HashSet<>();
    List<TreeNode> forest=new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int value:to_delete){
            delete_set.add(value);
        }
        if(postorder(root)!=null){
            forest.add(root);
        }
        return forest;
    }
    private TreeNode postorder(TreeNode root){
        if(root==null)return null;
        root.left=postorder(root.left);
        root.right=postorder(root.right);
        if(delete_set.contains(root.val)){
            if(root.left!=null){
                forest.add(root.left);
            }
            if(root.right!=null){
                forest.add(root.right);
            }
            return null;
        }
        return root;
    }
}