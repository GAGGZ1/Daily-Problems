import java.util.*;
class Solution {
  public void topo(int curr,ArrayList<ArrayList<Integer>> adj,  Stack<Integer>st, boolean[]vis){
      vis[curr]=true;
      
      for(int e:adj.get(curr)){
          if(!vis[e]){
              topo(e,adj,st,vis);
          }
      }
      st.push(curr);
  }
   public void dfs(int curr,ArrayList<ArrayList<Integer>> adj, boolean[]vis){
      vis[curr]=true;
      
      for(int e:adj.get(curr)){
          if(!vis[e]){
              dfs(e,adj,vis);
          }
      }
     
  }
  // Function to find number of strongly connected components in the graph.
  public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
      int n=adj.size();
      Stack<Integer>st=new Stack<>();
       boolean[]vis=new boolean[n];
      for(int i=0;i<n;i++){
          if(!vis[i]){
              topo(i,adj,st,vis);
          }
      }
      Arrays.fill(vis,false);
      ArrayList<ArrayList<Integer>>ls=new ArrayList<>();
      for(int i=0;i<n;i++){
          ls.add(new ArrayList<>());
      }
      for(int i=0;i<n;i++){
          for(int e:adj.get(i)){
              ls.get(e).add(i);
          }
      }
      int count=0;
      while(!st.isEmpty()){
          int curr=st.pop();
          if(!vis[curr]){
              count++;
              dfs(curr,ls,vis);
          }
      }
      return count;
     
  }
}
