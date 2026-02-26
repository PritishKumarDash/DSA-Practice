/*
Problem: Palindrome LinkedList
Approach: Fast and slow pointer
Time Complexity: O(n)
Space Complexity: O(1)
*/
class Solution{
  public boolean isPalindrome(ListNode head){
    if(head == null || head.next == null){
      return true;
    }
    ListNode fast = head;
    ListNode slow = head;

    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode firstHalf = head;
    ListNode secondHalf = reverse(slow);

    while(secondHalf.next != null){
      if(firstHalf.val != secondHalf.val){
        return false;
      }
      firstHalf = firstHalf.next;
      secondHalf = secondHalf.next;
    }
    return true;
  }
  private ListNode reverse(ListNode head){
    ListNode prev = null;
    ListNode curr = head;
    while(curr != null){
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
}
