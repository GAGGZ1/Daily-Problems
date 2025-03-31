class Solution {
  public int orangesRotting(int[][] grid) {
      int freshcount = 0;
      int n = grid.length;
      int m = grid[0].length;
      Queue<int[]> q = new LinkedList<>();
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
              if (grid[i][j] == 1) {
                  freshcount++;
              } else if (grid[i][j] == 2) {
                  q.add(new int[] { i, j });
              }
          }
      }
      if (freshcount == 0)
          return 0;
      int time = 0;
      int dirx[] = { 1, 0, 0, -1 };
      int diry[] = { 0, 1, -1, 0 };
      while (!q.isEmpty()) {
          int size = q.size();
          for (int s = 0; s < size; s++) {
              int[] currloc = q.poll();
              int x = currloc[0];
              int y = currloc[1];
              for (int d = 0; d < 4; d++) {
                  int newx = dirx[d] + x;
                  int newy = diry[d] + y;
                  if (newx >= 0 && newx < n && newy >= 0 && newy < m && grid[newx][newy] == 1) {
                      q.add(new int[] { newx, newy });
                      freshcount--;
                      grid[newx][newy] = 2;

                  }
                  if (freshcount == 0) {
                      return time + 1;
                  }
              }
          }
          time++;
      }

      if (freshcount == 0)
          return time;
      return -1;

  }
}