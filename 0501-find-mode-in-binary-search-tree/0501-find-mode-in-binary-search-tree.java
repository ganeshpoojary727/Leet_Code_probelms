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
    int count=0;
    int maxcount=0;
    List<Integer> result=new ArrayList<>();
    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] ans=new int[result.size()];
        for(int i=0;i<result.size();i++){
            ans[i]=result.get(i);
        }
        return ans;
    }
    public void inorder(TreeNode node){
        if(node==null) return;
        inorder(node.left);
        if(prev==null || prev.val!=node.val){
            count=1;
        }
        else{
            count++;
        }
        if(count>maxcount){
            maxcount=count;
            result.clear();
            result.add(node.val);
        }
        else if(count==maxcount){
            result.add(node.val);
        }
        prev=node;
        inorder(node.right);
        }
    }
