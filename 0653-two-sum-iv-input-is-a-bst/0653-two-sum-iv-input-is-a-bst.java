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
    HashSet<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
    //     if(root == null){
    //         return false;
    //     }
    //     if(findPair(root, k) == 1) return true;
    //     return false;
    // }
    // int findPair(TreeNode root, int k){
    //     if(root == null){
    //         return 0;
    //     }
    //     int left = findPair(root.left, k);

    //     if(root.left != null && root.left.val + root.val == k){
    //         return 1;
    //     }

    //     int right = findPair(root.right, k);

    //     if(root.right != null && root.right.val + root.val == k){
    //         return 1;
    //     }

    //     else if(root.left != null && root.right != null && root.left.val + root.right.val == k){
    //         return 1;
    //     }
    //     return 0;
    // }
        if(root == null){
            return false;
        }
        if(set.contains(k - root.val)){
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);

    }
}