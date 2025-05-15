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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        inorder(root,path);
        return path;
    }

    public void inorder(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }
        inorder(root.left, path);
        path.add(root.val);
        inorder(root.right, path);
    }
}