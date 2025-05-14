import java.util.*;

class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Solution {

    public static int sumAtKthLevel(TreeNode<Integer> root, int k) {
        if (root == null)
            return 0;

        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode<Integer> curr = q.poll();
                if (level == k) {
                    sum += curr.data;
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            if (level == k)
                return sum;
            level++;
        }

        return 0;
    }
}
