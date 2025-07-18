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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode n = new TreeNode(val);
            n.left = root;
            return n;
        }
        return dfs(root, val, depth, 1);
    }

    public TreeNode dfs(TreeNode root, int val, int depth, int curr) {
        if (root == null)
            return null;

        if (curr == depth - 1) {

            TreeNode templeft = root.left;
            TreeNode tempright = root.right;
            root.left = new TreeNode(val);
            root.right = new TreeNode(val);

            root.left.left = templeft;
            root.right.right = tempright;

            return root;
        }

        root.left = dfs(root.left, val, depth, curr + 1);
        root.right = dfs(root.right, val, depth, curr + 1);

        return root;
    }
}