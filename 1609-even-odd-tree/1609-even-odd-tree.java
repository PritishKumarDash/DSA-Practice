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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null){
            return true;
        }

        q.offer(root);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            Integer prev = null;
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if(level % 2 == 0){
                    if(cur.val % 2 == 0){
                        return false;
                    }
                    if(prev != null && cur.val <= prev){
                        return false;
                    }

                }else{
                    if(cur.val % 2 != 0){
                        return false;
                    }
                    if(prev != null && cur.val >= prev){
                        return false;
                    }
                }
                prev = cur.val;
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
            }
            level++;
        }
        return true;
    }
}