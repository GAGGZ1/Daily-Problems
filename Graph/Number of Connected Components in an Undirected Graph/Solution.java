import java.util.*;
class Solution {
  public int countComponents(int n, int[][] edges) {
       ArrayList<Edge>[]graph= buildGraph(n,edges);
       return nOfConnCom(n,graph);

  }
  public static int nOfConnCom(int n, ArrayList<Edge>[]graph){
      boolean[]visited=new boolean[n];
      Queue<Integer>q=new LinkedList<>();
      int count=0;

      for(int i=0;i<n;i++){
          if(visited[i]==false){
              count++;
              q.add(i);
              visited[i]=true;

              while(!q.isEmpty()){
                  int curr=q.poll();
                  for(Edge e:graph[curr]){
                      int dest=e.dest;
                      if(visited[dest]==false){
                          q.add(dest);
                          visited[dest]=true;
                      }
                  }
              }
          }
      }
      return count;
  }
  
  static class Edge{
      int src;
      int dest;
      
      public Edge(int src,int dest){
          this.src=src;
          this.dest=dest;
      }
  }
  public static ArrayList<Edge>[]  buildGraph(int n,int[][]edgesArray){
       ArrayList<Edge>[] adjList = new ArrayList[n]; 

      for (int i = 0; i < n; i++) {
          adjList[i] = new ArrayList<>();
      }
      
      for(int[] e:edgesArray){
          int u=e[0];
          int v=e[1];
          adjList[u].add(new Edge(u,v));
          adjList[v].add(new Edge(v,u));
          
      }
      return adjList;
  }
  
}
