/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
  public int findBottomLeftValue(TreeNode root) {
      // Initialize a queue for level-order traversal
      Queue<TreeNode> q = new LinkedList<>();
      q.offer(root); // Add the root node to the queue

      // Perform level-order traversal
      while (q.peek() != null) {
          root = q.poll(); // Remove and process the front node

          // Add the right child first, then the left child
          // This ensures the last processed node is the leftmost node of the bottom level
          if (root.right != null)
              q.offer(root.right);
          if (root.left != null)
              q.offer(root.left);
      }

      // Return the value of the last processed node, which is the bottom-left value
      return root.val;
  }
}