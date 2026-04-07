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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        

        while(!que.isEmpty()){
            int level = que.size();
            List<Integer> currentLevel = new ArrayList<>();

            for(int i = 0; i < level; i++){
                TreeNode node = que.poll();

                currentLevel.add(node.val);

                if(node.left != null){
                    que.offer(node.left);
                }
                if(node.right != null){
                    que.offer(node.right);
                }
            }
            // res.add(0, currentLevel); Time complexity - 0(n^2)
             res.add(currentLevel);
        }
        Collections.reverse(res); // Time complexity - 0(n)
        return res;
    }
}