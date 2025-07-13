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
    private long totalSum = 0;
    private long maxRes = 0;
    private final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        totalSum = findTotalSum(root);
        solve(root);
        return (int) (maxRes % MOD);
    }

    public int findTotalSum(TreeNode root) {
        if (root == null)
            return 0;
        return root.val + findTotalSum(root.left) + findTotalSum(root.right);
    }

    public int solve(TreeNode root) {
        if (root == null)
            return 0;

        int currSum = solve(root.left) + solve(root.right) + root.val;
        long product = (long) currSum * (totalSum - currSum);
        maxRes = Math.max(maxRes, product);
        return currSum;
    }
}