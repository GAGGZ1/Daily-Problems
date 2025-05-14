import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class BinaryTree {

    // Function to construct a binary tree from level order input
    public static TreeNode buildTreeFromLevelOrder(int depth, int[] nodes) {
        if (nodes == null || nodes.length == 0) return null;
        
        // Root node
        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < nodes.length) {
                current.left = new TreeNode(nodes[i]);
                queue.add(current.left);
                i++;
            }

            // Right child
            if (i < nodes.length) {
                current.right = new TreeNode(nodes[i]);
                queue.add(current.right);
                i++;
            }
        }

        return root;
    }

    // Function to perform inorder traversal and print the tree
    public static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the depth
        System.out.print("Enter depth: ");
        int depth = sc.nextInt();

        // Read the array elements
        System.out.print("Enter the node values in level order (space-separated): ");
        sc.nextLine();  // Consume the remaining newline
        String[] input = sc.nextLine().split(" ");
        int[] nodes = new int[input.length];
        
        for (int i = 0; i < input.length; i++) {
            nodes[i] = Integer.parseInt(input[i]);
        }

        // Build the tree using level order
        TreeNode root = buildTreeFromLevelOrder(depth, nodes);

        // Print the inorder traversal of the tree
        System.out.println("Inorder traversal of the tree:");
        inorder(root);
    }
}
