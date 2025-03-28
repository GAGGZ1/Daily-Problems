import java.util.*;

class Solution {
    static class Edge {
        int src;
        int dest;
        boolean isForward;

        public Edge(int src, int dest, boolean isForward) {
            this.src = src;
            this.dest = dest;
            this.isForward = isForward;
        }

    }

    public static ArrayList<Edge>[] buildGraph(int v, int[][] edges) {
        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();

        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int vv = edges[i][1];
            graph[u].add(new Edge(u, vv, true));
            graph[vv].add(new Edge(vv, u, false));
        }

        return graph;

    }

    public static int bfs(int v, ArrayList<Edge>[] graph) {
        int ans = 0;
        boolean visited[] = new boolean[v];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (Edge e : graph[curr]) {

                if (!visited[e.dest]) {
                    q.add(e.dest);
                    visited[e.dest] = true;
                    if (e.isForward == true) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    public int minReorder(int n, int[][] connections) {
        ArrayList<Edge>[] graph = buildGraph(n, connections);
        int ans = bfs(n, graph);
        return ans;

    }
}