
// User function Template for Java
/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    void leftside(Node root){
        //base: root : null || root:leaf node
        if(root==null || root.left==null && root.right==null)return;
        ls.add(root.data);
        
        if(root.left!=null){
            leftside(root.left);
        }
        else{
            leftside(root.right);
        }
        
        
    }
    void rightside(Node root){
        //base: root : null || root:leaf node
        if(root==null || root.left==null && root.right==null)return;
        
        
        if(root.right!=null){
            rightside(root.right);
        }
        else{
            rightside(root.left);
        }
        ls.add(root.data);
        
    }
    void leaf(Node root){
        if(root==null)return;
        
        if(root.left==null && root.right==null){
            ls.add(root.data);
        }
        leaf(root.left);
        leaf(root.right);
    }
     private ArrayList<Integer>ls;
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        if(root==null)return new ArrayList<>();
        ls=new ArrayList<>();
        //root
        ls.add(root.data);
        //left side except leaf
        leftside(root.left);
        
        //leaf
        if(root.left!=null || root.right!=null){
            leaf(root);
        }
        
        //right side (reverse) except leaf
        rightside(root.right);
        
        return ls;
        
    }
}
