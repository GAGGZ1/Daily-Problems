/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// 1. insert copy nodes in bw
// 2. connect random pointers
// 3. connect next pointers

class Solution {
    public Node copyRandomList(Node head) {
        // 1
        Node temp = head;
        while (temp != null) {
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = temp.next.next;
        }

        // 2
        temp = head;
        while (temp != null) {
            Node copynode = temp.next;
            if (temp.random != null)
                copynode.random = temp.random.next;
            temp = temp.next.next;
        }

        // 3
        Node dummy = new Node(-1);
        Node res = dummy;
        temp = head;
        while (temp != null) {
            res.next = temp.next;
            temp.next = temp.next.next;

            res = res.next;
            temp = temp.next;

        }

        return dummy.next;
    }
}