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
    public class Pairbst{
        long max;
        long min;
       boolean isbst;
       Pairbst(long min,long max,boolean isbst){
        this.min=min;
        this.max=max;
        this.isbst=isbst;
       }

      
    }
    public boolean isValidBST(TreeNode root) {
       return helper(root).isbst;
    }
    private Pairbst helper(TreeNode root){
        if (root == null) {
            return new Pairbst(Long.MAX_VALUE, Long.MIN_VALUE, true);
        }

        Pairbst left = helper(root.left);
        Pairbst right = helper(root.right);

        boolean isCurrentBST = left.isbst && right.isbst &&
                (root.val > left.max) && (root.val < right.min);

        long min = Math.min(root.val, Math.min(left.min, right.min));
        long max = Math.max(root.val, Math.max(left.max, right.max));

        return new Pairbst(min, max, isCurrentBST);
    }
}