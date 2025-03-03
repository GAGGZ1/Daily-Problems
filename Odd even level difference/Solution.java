class Solution
{
    int getLevelDiff(Node root)
    {
        int[] sums = new int[2]; // sums[0] -> stores sum of odd level nodes, sums[1] -> stores sum of even level nodes
        dfs(root, 1, sums); // Start DFS traversal from root at level 1
        return sums[0] - sums[1]; // Return difference between odd level sum and even level sum
    }

    void dfs(Node node, int level, int[] sums)
    {
        if (node == null) return; // Base case: if node is null, return

        if (level % 2 == 0) // Check if the current level is even
        {
            sums[1] += node.data; // Add the node's value to even level sum
        }
        else // If the current level is odd
        {
            sums[0] += node.data; // Add the node's value to odd level sum
        }

        // Recursive calls to process left and right subtrees, increasing level by 1
        dfs(node.left, level + 1, sums);
        dfs(node.right, level + 1, sums);
    }
}
