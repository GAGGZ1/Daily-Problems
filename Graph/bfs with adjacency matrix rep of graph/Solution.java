import java.util.*;
public class Solution {
  public static class GraphWithoutWt{
    private int[][]adjMatrix;
    private int v;

    public GraphWithoutWt(int v){
      this.v=v;
      adjMatrix=new int[v][v];
    }
    public void addEdge(int src,int dest){
      adjMatrix[src][dest]=1;
      adjMatrix[dest][src]=1;
    }
  
 
  public void bfs(int startNode){
    boolean[] visited=new boolean[v];
    Queue<Integer>q=new LinkedList<>();
    q.add(startNode);
    visited[startNode]=true;
    System.out.println("BFS Traversal starting from node " + startNode + ":");

    while(!q.isEmpty()){
      int currNode=q.poll();
      System.out.print(currNode + " "); // Process the Current node
      for(int i=0;i<v;i++){
        if(!visited[i] && adjMatrix[currNode][i]==1){
          q.add(i);
          visited[i]=true;
        }
      }
    }
    System.out.println();
  }
}
public static void main(String[] args) {
  int v=4;
  GraphWithoutWt graph=new GraphWithoutWt(v);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(1, 3);
    graph.bfs(0);

}}

