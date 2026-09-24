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
     ArrayList<String> list=new ArrayList<>();
    public String smallestFromLeaf(TreeNode root) {
       if(root==null)return " ";
       dfs(root,"");
       Collections.sort(list);
       return list.get(0);
        
    }
    public void dfs(TreeNode root,String s){
        s = (char)('a' + root.val) + s;
        if(root.left==null && root.right==null){
            list.add(s);
        }
        if(root.left!=null ){
            dfs(root.left,s);
        }
        if(root.right!=null ){
            dfs(root.right,s);
        }
    }
}