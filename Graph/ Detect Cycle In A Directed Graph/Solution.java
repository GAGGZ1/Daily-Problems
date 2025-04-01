import java.util.ArrayList;
public class Solution {
  static class Edge{
    int src;
    int dest;
    public Edge(int src,int dest){
      this.src=src;
      this.dest=dest;
    }

  }
  public static ArrayList<Edge>[] buildGraph(int n,
    ArrayList < ArrayList < Integer >> edges){
    ArrayList<Edge>[]graph=new ArrayList[n+1];
    for(int i=0;i<=n;i++){
      graph[i]=new ArrayList<>();
    }
    for (int i = 0; i < edges.size(); i++) {
      int u=edges.get(i).get(0);
      int v=edges.get(i).get(1);
      graph[u].add(new Edge(u,v));
    }
    return graph;
  }
  public static boolean dfs(ArrayList<Edge>[] graph
  ,int curr,boolean[]visited,boolean[]rec){
    visited[curr]=true;
    rec[curr]=true;

    for(int i=0;i<graph[curr].size();i++){
      Edge e=graph[curr].get(i);
      if(rec[e.dest]){
        return true;
      }
      else if(!visited[e.dest]){
        if( dfs(graph,e.dest,visited,rec)){
          return true;
        }
      }
    }
    rec[curr]=false;
    return false;
  }
  public static boolean detectCycleInDirectedGraph
  (int n, ArrayList < ArrayList < Integer >> edges) {
     ArrayList<Edge>[] graph = buildGraph(n, edges);
        boolean[] visited = new boolean[n + 1];
        boolean[] rec = new boolean[n + 1];

      
        for (int i = 1; i <= n; i++) { 
            if (!visited[i]) {
                if (dfs(graph, i, visited, rec)) {
                    return true;
                }
            }
        }

       return false;
  }
}