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
    public int maxLevelSum(TreeNode root) {
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return level;

        int maxLevel = 0;
        int maxSum = Integer.MIN_VALUE;
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();

                sum += cur.val;

                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
                
            }
            level++;
            if(sum > maxSum){
                maxSum = sum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }
}