/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 class Solution {
  /**
   * Reverses a singly linked list.
   * 
   * @param head The head of the linked list.
   * @return The new head of the reversed linked list.
   */
  public ListNode reverseList(ListNode head) {
      // If the list is empty, return null
      if (head == null)
          return null;

      // Initialize three pointers:
      ListNode current = head; // Current node being processed
      ListNode prev = null; // Previous node (initially null since head will become tail)
      ListNode next = null; // Next node (used to temporarily store next node)

      // Iterate through the list
      while (current != null) {
          next = current.next; // Store the next node
          current.next = prev; // Reverse the link (point current node to the previous one)
          prev = current; // Move prev forward
          current = next; // Move current forward
      }

      // prev is now the new head of the reversed list
      return prev;
  }
}
