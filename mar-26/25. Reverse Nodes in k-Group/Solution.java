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
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = length(head);
        int grps = n / k;

        ListNode newHead = null;

        ListNode currGrpHead = head;
        ListNode prevGrpTail = null;

        for (int i = 0; i < grps; i++) {
            ListNode curr = currGrpHead;
            ListNode prev = null;
            for (int j = 0; j < k; j++) {
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }
            if (prevGrpTail == null) {
                newHead = prev;
            } else {
                prevGrpTail.next = prev;
            }
            currGrpHead.next = curr;

            prevGrpTail = currGrpHead;
            currGrpHead = curr;
        }

        return newHead;

    }

    public int length(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}