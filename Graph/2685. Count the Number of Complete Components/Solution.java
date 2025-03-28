
import java.util.*;

public class Solution{
  static class Edge{
    int src;
    int dest;

    public Edge(int src,int dest){
      this.src=src;
      this.dest=dest;
    }

  }
  public static ArrayList<Edge>[] buildGraph(int v,int[][]edges){
    ArrayList<Edge>graph[]=new ArrayList[v];
    for(int i=0;i<v;i++){
      graph[i]=new ArrayList<>();
    }

    for(int i=0;i<edges.length;i++){
      
      int u=edges[i][0];
      int vv=edges[i][1];
      graph[u].add(new Edge(u,vv));
      graph[vv].add(new Edge(vv,u));

    }
    return graph;
    
  }
  public static void printGraph(ArrayList<Edge>[]graph){
    for(int i=0;i<graph.length;i++){
      System.out.print(i + " -> ");
      for(Edge e:graph[i]){
        System.out.print(e.dest + " ");
      }
      System.out.println();
    }
  }
  public static int[] bfs(boolean visited[],ArrayList<Edge>[]graph,int v,int src){
    int countEdge=0;
    int countNodes=0;
   
    Queue<Integer>q=new LinkedList<>();
    q.add(src);
    visited[src]=true;

    while(!q.isEmpty()){
      int curr=q.poll();
      countNodes++;
      for(Edge e:graph[curr]){
        countEdge++;
        int n=e.dest;
        if(!visited[n]){
          q.add(n);
          visited[n]=true;
        }
      }


    }


    return new int[]{countNodes,countEdge/2};
  }
  public static void main(String[] args) {
    int v=6;
    // int [][]edges = {{0,1},{0,2},{1,2},{3,4}};
    int [][]edges =  {{0,1},
    {0,2},{1,2},{3,4},{3,5}};
    ArrayList<Edge>[]graph=buildGraph(v,edges);
    // printGraph(graph);
    // int numOfEdges=bfs(graph,v,0);
    // System.out.println(numOfEdges);
    boolean visited[]=new boolean[v];
    int ans=0;
    for(int i=0;i<v;i++){
      if(!visited[i]){
        int result[]=bfs(visited,graph,v,i);
        int n=result[0];
        int m=result[1];
        if(m==((n*(n-1))/2)){
          ans++;
        }

    }}
System.out.println("ans = "+ ans);
  }
}