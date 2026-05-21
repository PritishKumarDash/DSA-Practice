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
    String smallestStr = "";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, "");
        return smallestStr;
    }
    void dfs(TreeNode root, String currStr){
        if(root == null) return;

        currStr = (char)(root.val + 'a') + currStr;

        if(root.left == null && root.right == null){
            if(smallestStr == "" || smallestStr.compareTo(currStr) > 0){
                smallestStr = currStr;
            }
        }
        dfs(root.left, currStr);
        dfs(root.right, currStr);
    }
}