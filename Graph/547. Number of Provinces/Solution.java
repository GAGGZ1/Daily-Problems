class Solution {
  public int findCircleNum(int[][] isConnected) {
      int v = isConnected.length;
      boolean[] visited = new boolean[v];
      int count=0;
      for (int i = 0; i < v; i++) {
          if (!visited[i]) {
              count++;
              bfs(i,visited,v,isConnected);
          }
      }
      return count;

  }
  public void bfs(int startNode ,boolean[] visited,int v,int[][]adjMatrix){
      Queue<Integer>q=new LinkedList<>();
      q.add(startNode);
      visited[startNode]=true;
      while(!q.isEmpty()){
          int currNode=q.poll();
          for(int i=0;i<v;i++){
              if(!visited[i] && adjMatrix[currNode][i]==1){
                  q.add(i);
                  visited[i]=true;
              }
          }
      }
  }
}



////////// dfs approach //////
/// 
/// 
/// 




// class Solution {
//   public int findCircleNum(int[][] isConnected) {
//       int v = isConnected.length;
//       boolean[] visited = new boolean[v];
//       int count = 0;
      
//       for (int i = 0; i < v; i++) {
//           if (!visited[i]) {
//               count++;
//               dfs(i, visited, isConnected);
//           }
//       }
//       return count;
//   }

//   private void dfs(int node, boolean[] visited, int[][] adjMatrix) {
//       visited[node] = true;
//       for (int i = 0; i < adjMatrix.length; i++) {
//           if (!visited[i] && adjMatrix[node][i] == 1) {
//               dfs(i, visited, adjMatrix);
//           }
//       }
//   }
// }
