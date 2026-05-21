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
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> temp = new ArrayList<>();
        int sum = 0;

        fill(root, temp, sum, targetSum);

        return result;
    }
    void fill(TreeNode root, List<Integer> temp, int sum, int targetSum){
        if(root == null) return;

        sum += root.val;
        temp.add(root.val);

        if(root.left == null && root.right == null){
            if(sum == targetSum){
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        fill(root.left, new ArrayList<>(temp), sum, targetSum);
        fill(root.right, new ArrayList<>(temp), sum, targetSum);
    }

}