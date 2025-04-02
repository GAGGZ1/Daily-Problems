class Solution {

  static class Edge {
      int src;
      int dest;

      public Edge(int src, int dest) {
          this.src = src;
          this.dest = dest;
      }
  }

  public ArrayList<Edge>[] buildGraph(int[][] edge) {
      int n = edge.length;
      ArrayList<Edge>[] graph = new ArrayList[n];
      for (int i = 0; i < n; i++) {
          graph[i] = new ArrayList<>();
      }
      for (int i = 0; i < n; i++) {
          int[] arr = edge[i];
          if (arr.length == 0)
              continue;
          for (int j = 0; j < arr.length; j++) {
              graph[i].add(new Edge(i, arr[j]));
          }
      }
      return graph;
  }

  public List<Integer> eventualSafeNodes(int[][] edge) {
      int n = edge.length;
      ArrayList<Edge>[] graph = buildGraph(edge);
      boolean[] visited = new boolean[n];
      boolean[] rec = new boolean[n];
      boolean[] safe = new boolean[n];
      ArrayList<Integer> arr = new ArrayList<>();

      for (int i = 0; i < n; i++) {

          if (dfs(graph, i, visited, rec)) {
              safe[i] = false;
          } else {
              safe[i] = true;
          }
      }
      for (int i = 0; i < n; i++) {
          if (safe[i]) {
              arr.add(i);
          }
      }
      return arr;
  }

  public boolean dfs(ArrayList<Edge>[] graph, int curr, boolean[] visited,
          boolean[] rec) {

      visited[curr] = true;
      rec[curr] = true;

      for (int i = 0; i < graph[curr].size(); i++) {
          Edge e = graph[curr].get(i);
          if (rec[e.dest]) {
              return true;

          } else if (!visited[e.dest]) {
              if (dfs(graph, e.dest, visited, rec)) {
                  return true;
              }
          }
      }
      rec[curr] = false;
      return false;
  }
}