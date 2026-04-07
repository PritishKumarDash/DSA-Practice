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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        Deque<TreeNode> que = new ArrayDeque<>();
        que.offer(root);
        boolean reverse = false;

        while(!que.isEmpty()){
            int levelSize = que.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for(int i = 0; i < levelSize; i++){
                if(!reverse){
                    TreeNode currentNode = que.pollFirst();
                    currentLevel.add(currentNode.val);

                    if(currentNode.left != null){
                        que.addLast(currentNode.left);
                    }
                    if(currentNode.right != null){
                        que.addLast(currentNode.right);
                    }
                }else{
                    TreeNode currentNode = que.pollLast();
                    currentLevel.add(currentNode.val);

                    if(currentNode.right != null){
                        que.addFirst(currentNode.right);
                    }
                    if(currentNode.left != null){
                        que.addFirst(currentNode.left);
                    }
                }
            }

            res.add(currentLevel);
            reverse = !reverse; 
        }

        return res;
    }
}