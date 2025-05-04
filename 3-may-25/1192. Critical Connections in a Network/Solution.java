class Solution {
  class Edge {
      int src;
      int dest;

      public Edge(int s, int d) {
          this.src = s;
          this.dest = d;

      }
  }

  public ArrayList<Edge>[] build(List<List<Integer>> c,
          int n) {
      ArrayList<Edge>[] graph = new ArrayList[n];
      for (int i = 0; i < n; i++) {
          graph[i] = new ArrayList<>();
      }
      for (List<Integer> l : c) {
          int u = l.get(0);
          int v = l.get(1);
          graph[u].add(new Edge(u, v));
          graph[v].add(new Edge(v, u));
      }
      return graph;
  }

  public void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[], int[] dt, int[] low, int time, int par,
          List<List<Integer>> bridges) {
      vis[curr] = true;
      dt[curr] = low[curr] = ++time;
      for (int i = 0; i < graph[curr].size(); i++) {
          Edge e = graph[curr].get(i);
          if (e.dest == par) {
              continue;
          } else if (!vis[e.dest]) {
              dfs(graph, e.dest, vis, dt, low, time, curr, bridges);
              low[curr] = Math.min(low[curr], low[e.dest]);
              if (dt[curr] < low[e.dest]) {
                  bridges.add(Arrays.asList(curr, e.dest));
              }
          } else {
              low[curr] = Math.min(low[curr], dt[e.dest]);
          }
      }
  }

  public List<List<Integer>> getBridges(ArrayList<Edge> graph[], int n) {
      int dt[] = new int[n];
      int low[] = new int[n];
      int time = 0;
      boolean vis[] = new boolean[n];
      List<List<Integer>> bridges = new ArrayList<>();
      for (int i = 0; i < n; i++) {
          if (!vis[i]) {
              dfs(graph, i, vis, dt, low, time, -1, bridges);
          }
      }
      return bridges;
  }

  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
      ArrayList<Edge>[] graph = build(connections, n);
      return getBridges(graph, n);
  }
}