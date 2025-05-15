import java.util.*;

public class TreePathWithConsecutiveObstacles {

    static class Node {
        int val;
        int flag; // 0 = passable, 1 = obstacle
        Node left, right;

        Node(int val, int flag) {
            this.val = val;
            this.flag = flag;
        }
    }

    public static void main(String[] args) {
        // Input: parent-child pairs
        int[][] edges = {
                { 1, 2 },
                { 1, 3 },
                { 2, 4 },
                { 2, 5 },
                { 3, 6 },
                {3, 7 }

        };

        // Flags for each node: nodeVal → 0 (open) or 1 (obstacle)
        Map<Integer, Integer> flags = Map.of(
                1, 1,
                2, 0,
                3, 1,
                4, 1, // obstacle
                5, 0,
                6, 0,
                7, 0
        // obstacle
        );

        int maxConsecutiveObstacles = 1; // Allow up to 1 consecutive obstacle

        Node root = buildTree(edges, flags);
        int count = countValidPaths(root, 0, 0, maxConsecutiveObstacles);

        System.out.println(count == 0 ? -1 : count);
    }

    // Build binary tree from edges and flags
    public static Node buildTree(int[][] edges, Map<Integer, Integer> flags) {
        Map<Integer, Node> map = new HashMap<>();
        Set<Integer> childSet = new HashSet<>();

        for (int[] edge : edges) {
            int parentVal = edge[0];
            int childVal = edge[1];

            Node parent = map.getOrDefault(parentVal, new Node(parentVal, flags.get(parentVal)));
            Node child = map.getOrDefault(childVal, new Node(childVal, flags.get(childVal)));

            if (parent.left == null)
                parent.left = child;
            else if (parent.right == null)
                parent.right = child;

            map.put(parentVal, parent);
            map.put(childVal, child);
            childSet.add(childVal);
        }

        // Find root (not in child set)
        for (int val : map.keySet()) {
            if (!childSet.contains(val))
                return map.get(val);
        }
        return null;
    }

    // Count valid root-to-leaf paths with <= m consecutive obstacles
    public static int countValidPaths(Node node, int currentObstacles, int consecutiveObstacles,
            int maxConsecutiveObstacles) {
        if (node == null)
            return 0;

        // If this node is an obstacle, increment the obstacle count
        if (node.flag == 1) {
            currentObstacles++;
            consecutiveObstacles++;
        } else {
            consecutiveObstacles = 0; // Reset consecutive obstacles count
        }

        // If we've exceeded the allowed number of consecutive obstacles, stop this path
        if (consecutiveObstacles > maxConsecutiveObstacles) {
            return 0;
        }

        // If we've reached a leaf node and the path is valid, return 1
        if (node.left == null && node.right == null) {
            return 1;
        }

        // Recur for left and right subtrees
        return countValidPaths(node.left, currentObstacles, consecutiveObstacles, maxConsecutiveObstacles) +
                countValidPaths(node.right, currentObstacles, consecutiveObstacles, maxConsecutiveObstacles);
    }
}
