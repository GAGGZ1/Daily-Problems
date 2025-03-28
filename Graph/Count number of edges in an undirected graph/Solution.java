
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
  public static int bfs(ArrayList<Edge>[]graph,int v,int src){
    int count=0;
    boolean visited[]=new boolean[v];
    Queue<Integer>q=new LinkedList<>();
    q.add(0);
    visited[0]=true;

    while(!q.isEmpty()){
      int curr=q.poll();
      for(Edge e:graph[curr]){
        count++;
        int n=e.dest;
        if(!visited[n]){
          q.add(n);
          visited[n]=true;
        }
      }


    }


    return count/2;
  }
  public static void main(String[] args) {
    int v=6;
    int [][]edges = {{0,1},{0,2},{1,2},{3,4},{2,3},{4,5}};
    ArrayList<Edge>[]graph=buildGraph(v,edges);
    printGraph(graph);
    int numOfEdges=bfs(graph,v,0);
    System.out.println(numOfEdges);

  }
}