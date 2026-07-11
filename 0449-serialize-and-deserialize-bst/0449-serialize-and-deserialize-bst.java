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

    // Serialize
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        helper(root, list);
        return String.join(",", list);
    }

    public void helper(TreeNode root, List<String> list) {

        if (root == null) {
            list.add("null");
            return;
        }

        list.add(String.valueOf(root.val));

        helper(root.left, list);
        helper(root.right, list);
    }

    // Deserialize
    public TreeNode deserialize(String data) {

        List<String> list =
                new ArrayList<>(Arrays.asList(data.split(",")));

        Collections.reverse(list);

        return helper2(list);
    }

    public TreeNode helper2(List<String> list) {

        String val = list.remove(list.size() - 1);

        if (val.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));

        node.left = helper2(list);
        node.right = helper2(list);

        return node;
    }
}