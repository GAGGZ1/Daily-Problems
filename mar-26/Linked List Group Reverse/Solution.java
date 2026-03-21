/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node reverseKGroup(Node head, int k) {
        // code here
        return reverseKGroup2(head,k);
        
    }

    public Node reverseKGroup2(Node head, int k) {
        Node newHead = null;

        Node currGrpHead = head;
        Node prevGrpTail = null;

        while(currGrpHead!=null){
            Node curr = currGrpHead;
            Node prev = null;
            int j=0;
          while(j<k && curr!=null) {
                Node nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
                j++;
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
}
