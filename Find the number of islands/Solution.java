
class Solution {
  public void dfs(boolean[][]visited,char[][]grid,int i ,int j){
       int[] rNbr = { -1, -1, -1, 0, 0, 1, 1, 1 };
      int[] cNbr = { -1, 0, 1, -1, 1, -1, 0, 1 };
      visited[i][j] = true;

      for (int k = 0; k < 8; ++k) {
          int newR = i + rNbr[k];
          int newC = j + cNbr[k];

          if (isSafe(grid, newR, newC, visited)) {
              dfs( visited,grid, newR, newC);
          }
      }
  }
  public int numIslands(char[][] grid) {
      int n=grid.length;
      int m=grid[0].length;
      int count=0;
      boolean[][]visited=new boolean[n][m];
      
      for(int i=0;i<n;i++){
          for(int j=0;j<m;j++){
              if(!visited[i][j] && grid[i][j]=='1'){
                  dfs(visited,grid,i,j);
                  count++;
              }
          }
      }
      return count;
  }



  public boolean isSafe(char[][] grid, int i, int j, boolean[][] visited) {
      int n = grid.length;
      int m = grid[0].length;

      return i >= 0 && i < n && j >= 0 && j < m && grid[i][j] == '1' && !visited[i][j];
  }
}
