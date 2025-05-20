
class Tree {
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        
        int ans=-1;
        while(root!=null){
            if(root.data==key){
                return root.data;
            }
            else if(key<root.data){
                ans=root.data;
                root=root.left;
            }
            else{
                root=root.right;
            }
        }
        return ans;
    }
}
