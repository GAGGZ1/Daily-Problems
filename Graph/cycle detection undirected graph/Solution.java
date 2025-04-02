// 1. vis[n]=t:
//   par x -> cycle(true)
// 2. vis[n]=t:
//   par yes -> do nothing
// 3. vis[n]=f:
//   visit it -> call dfs

import java.util.*;

public class Solution {
    static class Edge {
        int src, dest;
        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Function to build an **undirected** graph
    public static void buildGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adding bidirectional edges
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2)); // Bidirectional

        graph[3].add(new Edge(3, 1));
        graph[1].add(new Edge(1, 3)); // Bidirectional

        graph[4].add(new Edge(4, 0));
        graph[0].add(new Edge(0, 4)); // Bidirectional

        graph[4].add(new Edge(4, 1));
        graph[1].add(new Edge(1, 4)); // Bidirectional

        graph[5].add(new Edge(5, 0));
        graph[0].add(new Edge(0, 5)); // Bidirectional

        graph[5].add(new Edge(5, 2));
        graph[2].add(new Edge(2, 5)); // Bidirectional
    }

    // Function to check for a cycle in an **undirected** graph using DFS
    public static boolean cycleInUndirectedGraph(ArrayList<Edge>[] graph, boolean[] visited, int curr, int parent) {
        visited[curr] = true;

        for (Edge e : graph[curr]) { 
            if (!visited[e.dest]) {
                if (cycleInUndirectedGraph(graph, visited, e.dest, curr)) {
                    return true;
                }
            } else if (e.dest != parent) { 
                // If the adjacent node is already visited and not the parent, a cycle exists
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        buildGraph(graph);

        boolean[] visited = new boolean[v];
        boolean hasCycle = false;

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (cycleInUndirectedGraph(graph, visited, i, -1)) {
                    hasCycle = true;
                    break;
                }
            }
        }

        if (hasCycle) {
            System.out.println("Cycle detected in the graph.");
        } else {
            System.out.println("No cycle detected in the graph.");
        }
    }
}
