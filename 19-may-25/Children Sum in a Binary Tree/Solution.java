
// User function Template for Java

/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

*/
class Solution {
    // Function to check whether all nodes of a tree have the value
    // equal to the sum of their child nodes.
    public static int isSumProperty(Node root) {
       return solve(root)?1:0; 
    }
    public static boolean solve(Node root){
        if(root==null){
            return true;
        }
        if(root.left==null && root.right==null)return true;
       
        int left = (root.left == null) ? 0 : root.left.data;
        int right=(root.right==null)?0:root.right.data;
        if(left+right!=root.data)return false;
       return solve(root.left) && solve(root.right);
    }
}