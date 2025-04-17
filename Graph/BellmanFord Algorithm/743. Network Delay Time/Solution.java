class Solution {
  static class Edge {
      int src;
      int dest;
      int wt;

      public Edge(int s, int d, int w) {
          this.src = s;
          this.dest = d;
          this.wt = w;
      }
  }

  public static ArrayList<Edge>[] createGraph(int[][] times, int n) {
      ArrayList<Edge>[] graph = new ArrayList[n];
      for (int i = 0; i < n; i++) {
          graph[i] = new ArrayList<>();

      }
      for (int[] t : times) {
          int u = t[0] - 1;
          int v = t[1] - 1;
          int d = t[2];
          graph[u].add(new Edge(u, v, d));
      }
      return graph;
  }

  public static int[] bellmanFord(ArrayList<Edge> graph[], int src, int V) {
      int[] dist = new int[V];
      for (int i = 0; i < V; i++) {
          if (i != src) {
              dist[i] = Integer.MAX_VALUE;
          }
      }
      for (int k = 0; k < V - 1; k++) {
          for (int i = 0; i < V; i++) {
              for (int j = 0; j < graph[i].size(); j++) {
                  Edge e = graph[i].get(j);
                  int u = e.src;
                  int v = e.dest;

                  if (dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[v]) {
                      dist[v] = dist[u] + e.wt;
                  }
              }
          }
      }
      return dist;
  }

  public int networkDelayTime(int[][] times, int n, int k) {
      ArrayList<Edge>[] graph = createGraph(times, n);
      int dest[] = bellmanFord(graph, k - 1, n);

      int max = Integer.MIN_VALUE;
      for (int i = 0; i < dest.length; i++) {
          if (dest[i] == Integer.MAX_VALUE) {
              return -1;
          } else {
              max = Math.max(max, dest[i]);
          }
      }
      return max;
  }
}