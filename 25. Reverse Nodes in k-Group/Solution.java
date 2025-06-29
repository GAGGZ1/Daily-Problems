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
    class Pair {
        ListNode head;
        ListNode tail;

        Pair(ListNode head, ListNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1)
            return head;
        int len = calLen(head);
        if (len < k)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGrpEnd = dummy;
        ListNode grpStart = head;
        while (len >= k) {
            ListNode temp = grpStart;
            for (int i = 1; i < k; i++) {
                temp = temp.next;

            }
            ListNode nextGrpStart = temp.next;
            temp.next = null;

            Pair revRes = reverseList(grpStart);
            prevGrpEnd.next = revRes.head;
            revRes.tail.next = nextGrpStart;

            prevGrpEnd = revRes.tail;
            grpStart = nextGrpStart;

            len -= k;
        }
        return dummy.next;

    }

    public Pair reverseList(ListNode head) {
        if (head == null)
            return new Pair(null, null);

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return new Pair(prev, head);
    }

    public int calLen(ListNode head) {
        if (head == null)
            return 0;
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

}