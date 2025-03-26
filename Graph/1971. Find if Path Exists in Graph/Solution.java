class Solution {
  private class Edge {
      int src;
      int dest;

      public Edge(int src, int dest) {
          this.src = src;
          this.dest = dest;
      }
  }

  public ArrayList<Edge>[] buildGraph(int[][] edges, int n) {
      ArrayList<Edge>[] graph = new ArrayList[n];
      for (int i = 0; i < n; i++) {
          graph[i] = new ArrayList<>();
      }
      for (int[] e : edges) {
          int u = e[0];
          int v = e[1];
          graph[u].add(new Edge(u, v));
          graph[v].add(new Edge(v, u));
      }
      return graph;
  }

  public boolean validPath(int n, int[][] edges, int source, int destination) {
      boolean[] visited = new boolean[n];
      ArrayList<Edge>[] graph = buildGraph(edges, n);
      Queue<Integer> q = new LinkedList<>();
      q.add(source);
      visited[source] = true;
      while (!q.isEmpty()) {
          int curr = q.poll();
          if (curr == destination) {
              return true;
          }
          for (Edge e : graph[curr]) {
              int dest = e.dest;
              if (!visited[dest]) {
                  q.add(dest);
                  visited[dest] = true;
              }
          }
      }
      return false;

  }
}