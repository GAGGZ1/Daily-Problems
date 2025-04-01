class Solution {
  private int longestcycle = -1;

  static class Edge {
      int src;
      int dest;

      public Edge(int src, int dest) {
          this.src = src;
          this.dest = dest;
      }
  }

  public ArrayList<Edge>[] buildGraph(int[] edges) {
      int n = edges.length;
      ArrayList<Edge>[] graph = new ArrayList[n];
      for (int i = 0; i < n; i++) {
          graph[i] = new ArrayList<>();
      }
      for (int i = 0; i < n; i++) {
          if (edges[i] == -1)
              continue;
          graph[i].add(new Edge(i, edges[i]));
      }
      return graph;
  }

  public int longestCycle(int[] edges) {
      int n = edges.length;
      ArrayList<Edge>[] graph = buildGraph(edges);
      boolean[] visited = new boolean[n + 1];
      boolean[] rec = new boolean[n + 1];
      int[] entrytime = new int[n + 1];
      for (int i = 0; i < n; i++) {
          if (!visited[i]) {
              dfs(graph, i, visited, rec, entrytime, 0);
          }
      }
      return longestcycle;
  }

  public void dfs(ArrayList<Edge>[] graph, int curr, boolean[] visited,
          boolean[] rec, int[] entrytime, int time) {
      if (curr == -1)
          return;
      visited[curr] = true;
      rec[curr] = true;
      entrytime[curr] = time;

      for (int i = 0; i < graph[curr].size(); i++) {
          Edge e = graph[curr].get(i);
          if (rec[e.dest]) {
              int currlen = entrytime[curr] - entrytime[e.dest] + 1;
              longestcycle = Math.max(longestcycle, currlen);

          } else if (!visited[e.dest]) {
              dfs(graph, e.dest, visited, rec, entrytime, time + 1);
          }
      }
      rec[curr] = false;

  }
}