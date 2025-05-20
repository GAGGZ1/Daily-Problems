
class Solution {
    int counter = 0;
    int ans = -1;
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root, int k) {
        // Your code here
        solve(root, k);
        return ans;
        
    }


    public void solve(Node root, int k) {
        if (root == null) {
            return;
        }
        solve(root.right, k);
        
        counter++;
       
        
         if (counter == k ) {
            ans = root.data;
            return;
        }
        solve(root.left, k);
    }
}