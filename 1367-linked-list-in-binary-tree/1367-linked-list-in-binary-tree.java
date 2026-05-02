/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null) return false;

        return isSub(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    boolean isSub(ListNode a, TreeNode b){
        if(a == null) return true;
        if(b == null) return false;

        if(a.val != b.val) return false;

        return isSub(a.next, b.left) || isSub(a.next, b.right);
    }

}