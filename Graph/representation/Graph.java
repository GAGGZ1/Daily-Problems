import java.util.*;

public class Graph{
  static class Edge{
  int src;
  int dest;
  int wt;

  Edge(int src,int dest,int wt){
    this.src=src;
    this.dest=dest;
    this.wt=wt;
  }
}
static void createGraph(ArrayList<Edge>[]graph){
  for(int i=0;i<graph.length;i++){
    graph[i]=new ArrayList<>();
  }
  graph[0].add(new Edge(0, 1, 5));
        graph[0].add(new Edge(0, 2, 3));

        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 3, 2));

        graph[2].add(new Edge(2, 0, 3));
        graph[2].add(new Edge(2, 4, 4));

        graph[3].add(new Edge(3, 1, 2));

        graph[4].add(new Edge(4, 2, 4));
    
}
public static void main(String[] args){
  int V=5;
  ArrayList<Edge>[]graph=new ArrayList[V];
  createGraph(graph);
  for(int i=0;i<V;i++){
    System.out.print("Vertex "+i+" -> ");

    for(Edge e: graph[i]){
      System.out.print("("+e.dest+", weight="+e.wt+")");
    }
    System.out.println();
  }


}
}


