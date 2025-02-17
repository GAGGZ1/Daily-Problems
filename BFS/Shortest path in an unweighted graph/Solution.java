import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int v = 8;
        int e = 10;
        int s = 0;
        int d = 7;
        int[][] edges = {{0, 1}, {1, 2}, {0, 3}, {3, 4}, {4, 7}, {3, 7}, {6, 7}, {4, 5}, {4, 6}, {5, 6}};
        List<Integer> res = bfs(v, e, s, d, edges);
        System.out.println(res);
    }

    public static List<Integer> bfs(int v, int e, int s, int d, int[][] edges) {
        // Create adjacency list
        ArrayList<Integer>[] adjList = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            int u = edges[i][0];
            int v1 = edges[i][1];
            adjList[u].add(v1);
            adjList[v1].add(u); // For undirected graph
        }

        boolean[] visited = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        int[] parent = new int[v];
        Arrays.fill(parent, -1); 

        visited[s] = true;
        q.add(s);

        // BFS loop
        while (!q.isEmpty()) {
            int node = q.poll();

            if (node == d) {
                List<Integer> path = new ArrayList<>();
                for (int curr = d; curr != -1; curr = parent[curr]) {
                    path.add(curr);
                }
                Collections.reverse(path); 
                return path;
            }

            // Explore the neighbors
            for (int neighbor : adjList[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = node; 
                    q.add(neighbor);
                }
            }
        }

     
        return new ArrayList<>();
    }
}
