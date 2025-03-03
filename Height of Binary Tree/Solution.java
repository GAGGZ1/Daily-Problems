/************************************************************

 Following is the TreeNode class structure

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 ************************************************************/
public class Solution {
  // Function to find the height of a binary tree
  public static int heightOfBinaryTree(TreeNode root) {
      // Base case: If the tree is empty (root is null), return height as 0
      if (root == null) return 0;
      
      // Recursively calculate the height of the left and right subtrees
      int leftHeight = heightOfBinaryTree(root.left);
      int rightHeight = heightOfBinaryTree(root.right);
      
      // The height of the tree is the maximum of the left and right subtree heights + 1 (for the root node)
      return 1 + Math.max(leftHeight, rightHeight);
  }
}
