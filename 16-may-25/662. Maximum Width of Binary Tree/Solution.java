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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> idx = new LinkedList<>();
        q.add(root);
        idx.add(0);

        int maxw = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            int left = 0;
            int right = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                int curridx = idx.poll();
                if (i == 0)
                    left = curridx;
                if (i == size - 1)
                    right = curridx;

                if (node.left != null) {
                    q.add(node.left);
                    idx.add(curridx * 2);

                }
                if (node.right != null) {
                    q.add(node.right);
                    idx.add(curridx * 2 + 1);
                }
            }
            maxw = Math.max(maxw, right - left + 1);
        }
        return maxw;
    }
}