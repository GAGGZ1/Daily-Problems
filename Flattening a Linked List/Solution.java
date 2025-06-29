class Solution {
    // Function to flatten a linked list
    Node flatten(Node root) {
        if(root==null || root.next==null){
            return root;
            
            
        }
        Node headF=flatten(root.next);
        
        return merge(root,headF);
        
    }
    Node merge(Node f,Node s ){
        
        Node dummy=new Node(0);
        Node current=dummy;
        while(f!=null && s!=null){
            if(f.data<s.data){
                current.bottom=f;
                f=f.bottom;
            }
            else{
                current.bottom=s;
                s=s.bottom;
            }
            current=current.bottom;
            current.next=null;
        }
        
        if(f!=null){
            current.bottom=f;
        }
        else {
            current.bottom=s;
        }
        return dummy.bottom;
    }
    
}