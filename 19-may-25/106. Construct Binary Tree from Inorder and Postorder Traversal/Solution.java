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
    int idx;

    public TreeNode buildTree(int[] io, int[] po) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < io.length; i++) {
            map.put(io[i], i);
        }
        idx = po.length - 1;
        return solve(po, 0, io.length - 1, map);
    }

    public TreeNode solve(int[] po, int left, int right, HashMap<Integer, Integer> map) {
        if (left > right)
            return null;

        TreeNode root = new TreeNode(po[idx]);
        idx--;

        int nextidx = map.get(root.val);
        root.right = solve(po, nextidx + 1, right, map);
        root.left = solve(po, left, nextidx - 1, map);

        return root;

    }
}