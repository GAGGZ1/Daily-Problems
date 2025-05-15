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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        preorder(root, path);
        return path;
    }

    public void preorder(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        preorder(root.left, path);

        preorder(root.right, path);
    }
}
