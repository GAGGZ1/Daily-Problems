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
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    public List<TreeNode> helper(int s, int e) {
        List<TreeNode> ls = new ArrayList<>();
        if (s > e) {
            ls.add(null);
            return ls;
        }
        if (s == e) {
            ls.add(new TreeNode(s));
            return ls;
        }

        for (int i = s; i <= e; i++) {
            List<TreeNode> lefttree = helper(s, i - 1);
            List<TreeNode> righttree = helper(i + 1, e);

            for (TreeNode l : lefttree) {
                for (TreeNode r : righttree) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    ls.add(root);
                }
            }

        }
        return ls;
    }
}