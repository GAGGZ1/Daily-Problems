
// User function Template for Java
class Solution {
  // Function to return Breadth First Traversal of given graph.
  public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
     
      ArrayList<Integer> ans=new ArrayList<>();
      boolean[]visited=new boolean[V];
      Queue<Integer>q=new LinkedList<>();
     q.add(0);
     visited[0]=true;
          while(!q.isEmpty()){
              int curr=q.poll();
              ans.add(curr);
              
              for(int n:adj.get(curr)){
                
                  if(!visited[n]){
                      visited[n]=true;
                      q.add(n);
                  }
              }
          }
          
      
      return ans;
      
  }
  static class Edge{
      int src;
      int dest;
      public Edge(int src,int dest){
          this.src=src;
          this.dest=dest;
      }
  }
  public static ArrayList<Edge>[] buildGraph(int v,ArrayList<ArrayList<Integer>> adj){
      ArrayList<Edge>[]graph=new ArrayList[v];
      for(int i=0;i<v;i++){
          graph[i]=new ArrayList<>();
      }
      int i=0;
      for(ArrayList<Integer> e:adj){
          
          for(int j=0;j<e.size();j++){
              graph[i].add(new Edge(i,e.get(j)));
          }
          i++;
      }
      
      
      
      return graph;
  }
}