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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = false;
        List<List<Integer>> res = new ArrayList<>();
        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();
                temp.add(curr.val);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            if (flag) {
                Collections.reverse(temp);
            }
            res.add(temp);
            flag = !flag;
        }
        return res;
    }
}