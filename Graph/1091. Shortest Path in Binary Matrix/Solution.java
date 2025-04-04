class Solution {

  public int shortestPathBinaryMatrix(int[][] grid) {
      int n = grid.length;
      int m = grid[0].length;
      int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
      int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };
      if (grid[0][0] != 0 || grid[n - 1][m - 1] != 0)
          return -1;
      boolean[][] visited = new boolean[n][m];
      Queue<int[]> q = new LinkedList<>();
      q.add(new int[] { 0, 0, 0 });
      visited[0][0] = true;
      while (!q.isEmpty()) {
          int[] cell = q.poll();
          int x = cell[0];
          int y = cell[1];
          int dis = cell[2];
          if (x == n - 1 && y == n - 1) {
              return dis + 1;
          }
          for (int d = 0; d < 8; d++) {
              int newx = dx[d] + x;
              int newy = dy[d] + y;

              if (newx >= 0 && newx < n && newy >= 0 && newy < m && !visited[newx][newy] && grid[newx][newy] == 0) {
                  q.add(new int[] { newx, newy, dis + 1 });
                  visited[newx][newy] = true;
              }

          }
      }
      return -1;
  }
}