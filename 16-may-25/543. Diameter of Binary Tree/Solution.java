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
    public int heightTree(TreeNode root) {
        if (root == null)
            return 0;
        int left = heightTree(root.left);
        int right = heightTree(root.right);

        int maxheight = Math.max(left, right) + 1;
        return maxheight;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int d1 = diameterOfBinaryTree(root.left);
        int d2 = diameterOfBinaryTree(root.right);
        int d3 = heightTree(root.left) + heightTree(root.right);
        return Math.max(Math.max(d1, d2), d3);
    }
}