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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        idx = 0;
        for (int v : inorder) {
            map.put(v, i);
            i++;
        }

        return solve(preorder, 0, inorder.length - 1, map);

    }

    public TreeNode solve(int[] pre, int left, int right, HashMap<Integer, Integer> map) {
        if (left > right)
            return null;
        TreeNode root = new TreeNode(pre[idx]);
        idx++;
        int inidx = map.get(root.val);

        root.left = solve(pre, left, inidx - 1, map);
        root.right = solve(pre, inidx + 1, right, map);
        return root;
    }
}