/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> result = new ArrayList<>();

        // Step 1: Store parent of every node
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        buildParent(root, null, parent);

        // Step 2: BFS from target
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int distance = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // We have reached distance k
            if (distance == k) {

                for (TreeNode node : queue) {
                    result.add(node.val);
                }

                return result;
            }

            // Process current level
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                // Left child
                if (node.left != null &&
                    !visited.contains(node.left)) {

                    visited.add(node.left);
                    queue.offer(node.left);
                }

                // Right child
                if (node.right != null &&
                    !visited.contains(node.right)) {

                    visited.add(node.right);
                    queue.offer(node.right);
                }

                // Parent
                TreeNode par = parent.get(node);

                if (par != null &&
                    !visited.contains(par)) {

                    visited.add(par);
                    queue.offer(par);
                }
            }

            distance++;
        }

        return result;
    }


    private void buildParent(TreeNode node,
                             TreeNode par,
                             Map<TreeNode, TreeNode> parent) {

        if (node == null) {
            return;
        }

        parent.put(node, par);

        buildParent(node.left, node, parent);
        buildParent(node.right, node, parent);
    }
}