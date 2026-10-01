/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

    StringBuilder sb = new StringBuilder();

    serializeHelper(root, sb);

    return sb.toString();
}
private void serializeHelper(TreeNode root, StringBuilder sb) {

    if (root == null) {
        sb.append("null,");
        return;
    }

    sb.append(root.val).append(",");

    serializeHelper(root.left, sb);
    serializeHelper(root.right, sb);
}
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] arr = data.split(",");

        int[] index = {0};

        return deserializeHelper(arr, index);
    }

    private TreeNode deserializeHelper(String[] arr, int[] index) {

    if (arr[index[0]].equals("null")) {
        index[0]++;
        return null;
    }

    TreeNode root =
        new TreeNode(Integer.parseInt(arr[index[0]]));

    index[0]++;

    root.left = deserializeHelper(arr, index);

    root.right = deserializeHelper(arr, index);

    return root;
}
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));