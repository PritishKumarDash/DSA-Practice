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
    int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] freq = new int[10];
        dfs(root, freq);
        return count;
    }
    void dfs(TreeNode root, int[] freq){
        if(root == null) return;

        freq[root.val]++;

        if(root.left == null && root.right == null){
            int odd = 0;
            for(int i = 1; i <= 9; i++){
                if(freq[i] % 2 != 0) odd++;
            }
            if(odd <= 1){
                count++;
            }
        }

        dfs(root.left, freq);
        dfs(root.right, freq);

        freq[root.val]--;
    }
}