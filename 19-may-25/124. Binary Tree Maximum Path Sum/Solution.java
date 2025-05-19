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
    int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        solve(root);
        return max;
    }

    public int solve(TreeNode root){
        if(root==null)return 0;

        int l=solve(root.left);
        int r=solve(root.right);

        int ek_accha=Math.max(l,r)+root.val;
        int pura_accha=l+r+root.val;
        int bs_root=root.val;
        max=Math.max(Math.max(Math.max(max,ek_accha),bs_root),pura_accha);
        return Math.max(ek_accha,bs_root);
    }
}