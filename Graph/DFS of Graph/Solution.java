import java.util.*;
class Solution {
  private ArrayList<Integer> ans;
  private boolean[]visited;
  // Function to return a list containing the DFS traversal of the graph.
  public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
      // Code here
      ans=new ArrayList<>();
     
      visited=new boolean[adj.size()];
       dfs(adj,0);
      return ans;
  }
  public void dfs(ArrayList<ArrayList<Integer>> adj,int curr){
      visited[curr]=true;
      ans.add(curr);
      for(int n:adj.get(curr)){
          if(!visited[n]){
              dfs(adj,n);
          }
      }
  }
}