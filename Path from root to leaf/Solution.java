import java.util.*;

public class Solution {
    // TreeNode Definition
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        
    }
    
    // Function to find all root-to-leaf paths
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            path(root, "", result);
        }
        return result;
    }

    // Helper recursive function to build the paths
    private void path(TreeNode root, String currentPath, List<String> result) {
        if (root == null)
            return;

        currentPath += root.val;

        // If leaf node, add the current path to result
        if (root.left == null && root.right == null) {
            result.add(currentPath);
        } else {
            currentPath += "->";
            path(root.left, currentPath, result);
            path(root.right, currentPath, result);
        }
    }
    
    // Function to build a binary tree from level-order input, ignoring -1 as null
    public static TreeNode buildTree(int[] values, int index) {
        if (index >= values.length || values[index] == -1) return null; // Skip -1 values (null nodes)
        TreeNode root = new TreeNode(values[index]);
        root.left = buildTree(values, 2 * index + 1);  // Left child index
        root.right = buildTree(values, 2 * index + 2); // Right child index
        return root;
    }
    
    // Function to take input and process the tree
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Take the height of the tree (not used directly in the logic)
        System.out.print("Enter the height of the tree: ");
        int height = scanner.nextInt();
        
        // Total nodes in a complete binary tree of given height
        int totalNodes = (int) Math.pow(2, height + 1) - 1;
        
        // Take node values as input, where -1 represents a null node
        System.out.println("Enter the node values (space-separated, with -1 for null): ");
        int[] nodeValues = new int[totalNodes];
        for (int i = 0; i < totalNodes; i++) {
            nodeValues[i] = scanner.nextInt();
        }

        // Build the tree
        Solution solution = new Solution();
        TreeNode root = buildTree(nodeValues, 0);

        // Get all paths
        List<String> paths = solution.binaryTreePaths(root);
        
        // Print the result
        System.out.println("All root-to-leaf paths:");
        for (String path : paths) {
            System.out.println(path);
        }
        
        scanner.close();
    }
}
