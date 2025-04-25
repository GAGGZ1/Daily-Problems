class Solution {
    public int minCostConnectPoints(int[][] p) {

        int V = p.length;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph, p);
        return primsAlgo(graph, V);
    }

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

    public static void createGraph(ArrayList<Edge>[] graph,int[][]p) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        for(int i=0;i<p.length;i++){
            for(int j=i+1;j<p.length;j++){
                int wt=(Math.abs(p[i][0]-p[j][0])) + (Math.abs(p[i][1]-p[j][1]));
                graph[i].add(new Edge(i,j,wt));
                graph[j].add(new Edge(j,i,wt));
            }
        }

    

       
    }

    public static class Pair implements Comparable<Pair> {
        int node;
        int cost;

        public Pair(int n, int c) {
            this.node = n;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }

    }

    public static int primsAlgo(ArrayList<Edge>[] graph, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[V];

        pq.add(new Pair(0, 0));

        int mstCost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.node]) {
                vis[curr.node] = true;
                mstCost += curr.cost;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    if (!vis[e.dest]) {
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }
        return (mstCost);

    }

}