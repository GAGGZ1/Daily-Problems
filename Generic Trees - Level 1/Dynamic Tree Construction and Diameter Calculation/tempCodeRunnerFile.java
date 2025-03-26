import java.util.*;

class TreeNode {
    int data;
    List<TreeNode> children;

    public TreeNode(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode child) {
        this.children.add(child);
        child.children.add(this); // Bidirectional connection
    }
}

class Tree {
    Map<Integer, TreeNode> nodes = new HashMap<>();
    int nextValue = 2; // Start adding new nodes from 2

    public Tree(int rootData) {
        TreeNode rootNode = new TreeNode(rootData);
        nodes.put(rootData, rootNode); // Store root in map
    }

    public void addNode(int parent) {
        if (!nodes.containsKey(parent)) {
            System.out.println("Parent " + parent + " not found!");
            return;
        }
        TreeNode parentNode = nodes.get(parent);
        TreeNode childNode = new TreeNode(nextValue);
        parentNode.addChild(childNode); // Link parent and child
        nodes.put(nextValue, childNode);
        nextValue++;

        // Calculate and print the diameter after each insertion
        int diameter = calculateDiameter();
        System.out.println("Diameter after inserting " + (nextValue - 1) + ": " + diameter);
    }

    // Helper function to find the farthest node from a given start node
    private int[] bfs(TreeNode start) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> distance = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(start);
        distance.add(0);
        visited.add(start.data);

        int farthestNode = start.data;
        int maxDist = 0;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            int dist = distance.poll();

            if (dist > maxDist) {
                maxDist = dist;
                farthestNode = current.data;
            }

            for (TreeNode child : current.children) {
                if (!visited.contains(child.data)) {
                    queue.add(child);
                    distance.add(dist + 1);
                    visited.add(child.data);
                }
            }
        }

        return new int[]{farthestNode, maxDist};
    }

    // Function to calculate the diameter of the tree
    public int calculateDiameter() {
        if (nodes.size() == 1) return 0; // Only root exists

        TreeNode anyNode = nodes.get(1);
        int[] firstBfs = bfs(anyNode); // Find farthest node from any node
        int[] secondBfs = bfs(nodes.get(firstBfs[0])); // Find farthest from that node

        return secondBfs[1]; // The longest path found is the diameter
    }

    public void printTree(TreeNode node, String indent, Set<Integer> visited) {
        if (node == null || visited.contains(node.data)) return;
        visited.add(node.data);
        System.out.println(indent + "- " + node.data);
        for (TreeNode child : node.children) {
            printTree(child, indent + "  ", visited);
        }
    }

    public void printTreeFromRoot(int root) {
        printTree(nodes.get(root), "", new HashSet<>());
    }
}

public class TreeExample {
    public static void main(String[] args) {
        Tree tree = new Tree(1);
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of quaries");
        int n=sc.nextInt();
        int []parentArray=new int[n];
        System.out.println("Enter the parent array");
        for(int i=0;i<n;i++){
            parentArray[i]=sc.nextInt();
        }
        // int[] parentArray = {1, 1, 2, 1}; // Nodes are added in this order

        for (int parent : parentArray) {
            tree.addNode(parent);
        }

        // Print final tree structure
        System.out.println("\nFinal Tree Structure:");
        tree.printTreeFromRoot(1);
    }
}
