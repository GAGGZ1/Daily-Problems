
// User function Template for Java

/* class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution {
    int findsum(Node root){
        //root nhi hai
        if(root==null)return 0;
        
        //leaf node hai
        if(root.left==null && root.right==null){
            return root.data;
        }
        
        //left side jaoo aur sum laoo
        int left=findsum(root.left);
        //right side jaoo
        int right=findsum(root.right);
        
        
        //kya root node add hoga
        if(root.left!=null && root.right!=null){
            maxsum=Math.max(maxsum,root.data+left+right);
            return root.data+Math.max(left,right);
        }
        
        //left nhi hai
        if(root.left==null){
            return root.data+right;
        }
        //right nhi hai
        else
            return root.data+left;
        
    }
     int maxsum;
    int maxPathSum(Node root) {
        // code here
        maxsum=Integer.MIN_VALUE;
        int val=findsum(root);
        if(root.left!=null && root.right!=null){
            return maxsum;
        }
        return Math.max(maxsum,val);
        
    }
}