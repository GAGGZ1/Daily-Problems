/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        postorder(root, path);
        return path;
    }

    public void postorder(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }

        postorder(root.left, path);

        postorder(root.right, path);
        path.add(root.val);
    }
}
