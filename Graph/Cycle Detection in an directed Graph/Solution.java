import java.util.*;

public class Solution {
  static class Edge {
    int src;
    int dest;

    public Edge(int src, int dest) {
      this.src = src;
      this.dest = dest;
    }
  }

  public static void buildGraph(ArrayList<Edge> graph[]) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }
    graph[0].add(new Edge(0, 2));
    graph[1].add(new Edge(1, 0));
    graph[2].add(new Edge(2, 3));
    graph[3].add(new Edge(3, 0));

  }
  public static boolean dfs(ArrayList<Edge>[] graph ,int curr,boolean[]visited,boolean[]rec){

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

  public static void main(String[] args) {
    int v = 4;
    ArrayList<Edge>[] graph = new ArrayList[v];
    buildGraph(graph);
    boolean ans=dfs(graph,0,new boolean[v],new boolean[v]);
    System.out.println(ans);
  }
}