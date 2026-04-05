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
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode prev = dummyNode;

        while(prev.next != null && prev.next.next != null){
            ListNode curr = prev.next;
            ListNode next = curr.next;

            curr.next = next.next;
            next.next = curr;
            prev.next = next;

            prev = curr;
        }
        return dummyNode.next;
    }
}