
class Sol {
    // Function to return the floor of given number in BST.
    int floor(Node root, int key) {
        int ans=-1;
        // code here.
        while(root!=null){
            if(root.data==key){
                return key;
                
            }else if(key<root.data){
                
                root=root.left;
            }
            else{
                ans=root.data;
                root=root.right;
            }
        }
        return ans;
        
        
        
    }
}
