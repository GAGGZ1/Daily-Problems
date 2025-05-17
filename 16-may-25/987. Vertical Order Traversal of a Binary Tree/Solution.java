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
    class Tuple {
        TreeNode node;
        int col;
        int row;

        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.col = col;
            this.row = row;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> colmap = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple p = q.poll();
            TreeNode curr = p.node;
            int col = p.col;
            int row = p.row;

            colmap.putIfAbsent(col, new TreeMap<>());
            colmap.get(col).putIfAbsent(row, new PriorityQueue<>());
            colmap.get(col).get(row).add(curr.val);

            if (curr.left != null) {
                q.add(new Tuple(curr.left, row + 1, col - 1));
            }
            if (curr.right != null) {
                q.add(new Tuple(curr.right, row + 1, col + 1));
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : colmap.values()) {
            List<Integer> col = new ArrayList<>();
            for (PriorityQueue<Integer> ls : ys.values()) {
                while (!ls.isEmpty()) {
                    col.add(ls.poll());
                }

            }
            res.add(col);
        }
        return res;

    }

}