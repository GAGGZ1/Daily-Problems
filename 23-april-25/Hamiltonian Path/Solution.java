
class Solution {
    
    boolean check(int n, int m, ArrayList<ArrayList<Integer>> edges) {
          ArrayList<ArrayList<Integer>>graph=new ArrayList<>();
          
          for(int i=0;i<=n;i++){
              graph.add(new ArrayList<>());
          }
          
          for(ArrayList<Integer>a:edges){
              int u=a.get(0);
              int v=a.get(1);
              graph.get(u).add(v);
              graph.get(v).add(u);
          }
          for(int i=1;i<=n;i++){
              boolean[]vis=new boolean[n+1];
              if(dfs(i,vis,graph,1,n)){
                  return true;
              }
          }
          return false;
        
    }
    public boolean dfs(int curr,boolean[]vis,ArrayList<ArrayList<Integer>>graph,int count,int n){
        if(count==n)return true;
        vis[curr]=true;
        
        for(int e:graph.get(curr)){
            if(!vis[e]){
                if(dfs(e,vis,graph,count+1,n)){
                    return true;
                }
            }
        }
        vis[curr]=false;
        return false;
       
   }
}

// TC : O(n × 2^n)
// Space Complexity: O(n + m)