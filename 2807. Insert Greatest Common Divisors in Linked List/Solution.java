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
  public int gcd(int a, int b) {
      if (b == 0) {
          return a;
      }
      return gcd(b, a % b);
  }

  public ListNode insertGreatestCommonDivisors(ListNode head) {
      if (head.next == null)
          return head;

      ListNode ptr1 = head;
      ListNode ptr2 = head.next;

      while (ptr2 != null) {
          int val1 = ptr1.val;
          int val2 = ptr2.val;
          if (val1 < val2) {
              int temp = val2;
              val2 = val1;
              val1 = temp;
          }

          int gc = gcd(val1, val2);

          ListNode neww = new ListNode(gc);
          ptr1.next = neww;
          neww.next = ptr2;
          ptr1 = ptr2;

          ptr2 = ptr2.next;
      }
      return head;

  }
}