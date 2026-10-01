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
    List<TreeNode> list=new ArrayList<>();
    HashMap<String,Integer> map=new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
       dfs(root);
       return list;
    }
    public String dfs(TreeNode root){
        if(root==null){
            return "null";
        }
        String left=dfs(root.left);
        String right=dfs(root.right);

        String subtree=root.val+","+left+","+right;
        int count=map.getOrDefault(subtree,0);
        if(count==1){
            list.add(root);
        }
        map.put(subtree,count+1);
        return subtree;
    }
}