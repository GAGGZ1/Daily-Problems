class Solution {
  class Pair implements Comparable<Pair> {
      int node;
      int cost;
      int stops;

      public Pair(int node, int cost, int stops) {
          this.node = node;
          this.cost = cost;
          this.stops = stops;

      }

      @Override
      public int compareTo(Pair other) {
          return this.cost - other.cost;
      }
  }

  class Edge {
      int src;
      int wt;
      int dest;

      public Edge(int src, int dest, int wt) {
          this.src = src;
          this.dest = dest;
          this.wt = wt;
      }
  }

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
      List<Edge>[] graph = new ArrayList[n];
      for (int i = 0; i < n; i++) {
          graph[i] = new ArrayList<>();
      }
      for (int[] f : flights) {
          graph[f[0]].add(new Edge(f[0], f[1], f[2]));
      }
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      pq.add(new Pair(src, 0, 0));
      // dist[node][stops] = min cost to reach node with 'stops' stops
      int[][] dist = new int[n][k + 2];
      for (int[] d : dist) {
          Arrays.fill(d, Integer.MAX_VALUE);
      }
      dist[src][0] = 0;

      while (!pq.isEmpty()) {
          Pair curr = pq.remove();
          int node = curr.node;
          int cost = curr.cost;
          int stops = curr.stops;
          if (node == dst)
              return cost;
          if (stops <= k) {

              for (Edge e : graph[node]) {
                  int nextCost = cost + e.wt;
                  if (nextCost < dist[e.dest][stops + 1]) {
                      pq.add(new Pair(e.dest, cost + e.wt, stops + 1));
                      dist[e.dest][stops + 1] = nextCost;
                  }
              }
          }
      }
      return -1;
  }
}