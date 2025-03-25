import java.util.*;


class Solution {
  public ArrayList<ArrayList<Integer>> connectedcomponents(int v, int[][] edges) {
      ArrayList<Edge>[]graph=buildGraph(v,edges);
      return getConnCom(v,graph);
  }
  public static ArrayList<ArrayList<Integer>> getConnCom(int v, ArrayList<Edge>[]graph){
      boolean[] visited=new boolean[v];
      ArrayList<ArrayList<Integer>>components=new ArrayList<>();
      Queue<Integer>q=new LinkedList<>();
      for(int i=0;i<v;i++){
          if(!visited[i]){
              q.add(i);
              visited[i]=true;
              ArrayList<Integer>component=new ArrayList<>();
              while(!q.isEmpty()){
                  int curr=q.poll();
                  component.add(curr);
                  for(Edge e:graph[curr]){
                      int dest=e.dest;
                      if(!visited[dest]){
                          q.add(dest);
                          visited[dest]=true;
                      }
                  }
              }
              Collections.sort(component);
              components.add(component);
               
          }
      }
     
      return components;
  }
  static class Edge{
      int src;
      int dest;
      public Edge(int src,int dest){
          this.src=src;
          this.dest=dest;
      }
  }
  public static  ArrayList<Edge>[] buildGraph(int n,int[][]edgesArray){
      ArrayList<Edge>[] graph = new ArrayList[n];
       for(int i=0;i<n;i++){
           graph[i]=new ArrayList<>();
       }
       for(int [] e:edgesArray){
           int u=e[0];
           int v=e[1];
           graph[u].add(new Edge(u,v));
           graph[v].add(new Edge(v,u));
       }
       return graph;
  }
  
}