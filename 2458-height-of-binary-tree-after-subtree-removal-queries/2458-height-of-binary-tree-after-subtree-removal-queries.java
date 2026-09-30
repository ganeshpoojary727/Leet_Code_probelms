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

    Map<Integer, Integer> height = new HashMap<>();
    Map<Integer, Integer> answer = new HashMap<>();

    public int[] treeQueries(TreeNode root, int[] queries) {

        getHeight(root);

        dfs(root, 0, 0);

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            result[i] = answer.get(queries[i]);
        }

        return result;
    }

    private int getHeight(TreeNode node) {

        if (node == null) {
            return -1;
        }

        int left = getHeight(node.left);
        int right = getHeight(node.right);

        int h = 1 + Math.max(left, right);

        height.put(node.val, h);

        return h;
    }

    private void dfs(TreeNode node, int depth, int rest) {

        if (node == null) {
            return;
        }

        answer.put(node.val, rest);

        // Go to left child
        int rightHeight = (node.right == null)
                ? -1
                : height.get(node.right.val);

        dfs(
            node.left,
            depth + 1,
            Math.max(rest, depth + 1 + rightHeight)
        );

        // Go to right child
        int leftHeight = (node.left == null)
                ? -1
                : height.get(node.left.val);

        dfs(
            node.right,
            depth + 1,
            Math.max(rest, depth + 1 + leftHeight)
        );
    }
}