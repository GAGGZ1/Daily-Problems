
/* BST Node
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
} */

class Solution {
    public Node rightmost(Node node){
        while(node.right!=null){
            node=node.right;
        }
        return node;
    }
    public Node leftmost(Node node){
        while(node.left!=null){
            node=node.left;
        }
        return node;
    }
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        Node pre=null;
        Node suc=null;
        Node curr=root;
        while(curr!=null){
            if(curr.data<key){
                pre=curr;
                curr=curr.right;
            }else if(curr.data>key){
                suc=curr;
                curr=curr.left;
            }
            else{
                if(curr.left!=null){
                    pre=rightmost(curr.left);
                }
                if(curr.right!=null){
                    suc=leftmost(curr.right);
                }
                break;
        }
           
        } ArrayList<Node>result=new ArrayList<>();
            result.add(pre);
            result.add(suc);return result;
    }
}