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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return isSame(root1, root2);
    }
    boolean isSame(TreeNode a, TreeNode b){
        if(a == null && b == null){
            return true;
        }

        if(a == null || b == null) return false;

        if(a.val != b.val) return false;

        boolean noFlip = isSame(a.left, b.left) && isSame(a.right, b.right);

        boolean flip = isSame(a.left, b.right) && isSame(a.right, b.left);

        return flip || noFlip;
    }
}