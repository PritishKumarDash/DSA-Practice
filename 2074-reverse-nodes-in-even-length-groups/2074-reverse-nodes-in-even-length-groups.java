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
    public ListNode reverseEvenLengthGroups(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;
        int groupSize = 1;

        while (curr != null) {

            ListNode groupStart = curr;
            int count = 0;

            while (count < groupSize && curr != null) {
                curr = curr.next;
                count++;
            }

            if (count % 2 == 0) {

                ListNode newHead = reverse(groupStart, count);

                if (prev != null) {
                    prev.next = newHead;
                } else {
                    head = newHead;
                }

                groupStart.next = curr;
                prev = groupStart;

            } else {

                prev = groupStart;
                for (int i = 1; i < count; i++) {
                    prev = prev.next;
                }
            }

            groupSize++;
        }

        return head;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        for (int i = 0; i < k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}