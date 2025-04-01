class Solution {
  public void bfs(char[][] grid, int i, int j, boolean[][] visited) {
      int n = grid.length;
      int m = grid[0].length;
      Queue<int[]> q = new LinkedList<>();
      q.add(new int[] { i, j });
      visited[i][j] = true;
      int dirx[] = { 1, 0, 0, -1 };
      int diry[] = { 0, 1, -1, 0 };

      while (!q.isEmpty()) {
          int[] arr = q.poll();
          int x = arr[0];
          int y = arr[1];
          for (int d = 0; d < 4; d++) {
              int newx = x + dirx[d];
              int newy = y + diry[d];

              if (newx >= 0 && newx < n && newy >= 0 && newy < m && grid[newx][newy] == 'X' && !visited[newx][newy]) {
                  q.add(new int[] { newx, newy });
                  visited[newx][newy] = true;
              }
          }
      }
  }

  public int countBattleships(char[][] board) {
      int n = board.length;
      int m = board[0].length;
      boolean visited[][] = new boolean[n][m];
      int count = 0;
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
              if (!visited[i][j] && board[i][j] == 'X') {
                  count++;
                  bfs(board, i, j, visited);
              }
          }
      }
      return count;
  }
}