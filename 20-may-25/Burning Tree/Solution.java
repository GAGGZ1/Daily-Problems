
/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}  */
class Solution {
    static Node burnnode=null;
    static int timer;
    public static int minTime(Node root, int target) {
        // code here
        burnnode = null;
        timer = 0;

        
       
        find(root,target);
        burn(root,target);
        int ht=height(burnnode)-1;
        return Math.max(ht,timer);
    }
    public static void find(Node root,int target){
        if(root==null)return;
        if(root.data==target){
            burnnode=root;
            return;
        }
        find(root.left,target);
        find(root.right,target);
    }
    public static int height(Node root){
        if(root==null)return 0;
        // if(root==burnnode)return 1;
        int left=height(root.left);
        int right=height(root.right);
        return Math.max(left,right)+1;
    }
    public static int burn(Node root,int target){
        //root is absent
        if(root==null)return 0;
        //root is burning
       
        if(root.data==target){
            return -1;
        }
        
        //left se check kro burn hai ya height
        int left=burn(root.left,target);
        
        //right se check kro burn hai ya height
        int right=burn(root.right,target);
            
        
        
        //left side burn
        if(left<0){
            timer=Math.max(timer,Math.abs(left)+right);
            return left-1;
        }
        
        //right side burn
        if(right<0){
              timer=Math.max(timer,left+Math.abs(right));
            return right-1;
            
        }
        
        //nhi toh height
        
        return 1 + Math.max(left,right);
    }
}