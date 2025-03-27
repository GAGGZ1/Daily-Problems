import java.util.*;

class Solution{


  public static class GraphWithoutWt{
    private int[][] adjMatrix;
    private int v;
    public GraphWithoutWt(int v){
      this.v=v;
      adjMatrix=new int[v][v];
    }
    public void addEdge(int src,int dest){
      adjMatrix[src][dest]=1;
      adjMatrix[dest][src]=1;//for undirected graph
    }
      public void printGraph(){
        System.out.println("Adjacency Matrix:");
        for(int i=0;i<v;i++){
          System.out.print("| ");
          for(int j=0;j<v;j++){
            System.out.print(adjMatrix[i][j]+" ");
          }
          System.out.println("|");
        }
      }
    }
    public static void main(String[] args) {
      int v=4;
      GraphWithoutWt graph=new GraphWithoutWt(v);

      // Adding edges
      graph.addEdge(0, 1);
      graph.addEdge(0, 2);
      graph.addEdge(1, 2);
      graph.addEdge(1, 3);
      
      // Printing the adjacency matrix
      System.out.println("Adjacency Matrix of the Graph:");
      graph.printGraph();
      
    }


class GraphWithWeight {
  private int[][] adjMatrix;
  private int V;

  public GraphWithWeight(int vertices) {
      this.V = vertices;
      adjMatrix = new int[V][V];
      for (int[] row : adjMatrix) {
          Arrays.fill(row, Integer.MAX_VALUE); // Initialize with INF (no edge)
      }
  }

  public void addEdge(int src, int dest, int wt) {
      adjMatrix[src][dest] = wt;
      adjMatrix[dest][src] = wt; // For undirected graph
  }

  public void printGraph() {
      for (int i = 0; i < V; i++) {
          for (int j = 0; j < V; j++) {
              if (adjMatrix[i][j] == Integer.MAX_VALUE)
                  System.out.print("INF ");
              else
                  System.out.print(adjMatrix[i][j] + " ");
          }
          System.out.println();
      }
  }

  // public static void main(String[] args) {
  //     int V = 4;
  //     GraphWithWeight graph = new GraphWithWeight(V);

  //     graph.addEdge(0, 2, 2);
  //     graph.addEdge(1, 2, -1);
  //     graph.addEdge(1, 3, 2);
  //     graph.addEdge(2, 0, 3);
  //     graph.addEdge(2, 1, 0);
  //     graph.addEdge(2, 3, -1);
  //     graph.addEdge(3, 1, 3);
  //     graph.addEdge(3, 2, 4);

  //     System.out.println("Adjacency Matrix (Weighted Graph):");
  //     graph.printGraph();
  // }

  }
}
