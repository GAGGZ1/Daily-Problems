class Solution
{
    static int[] rowDir = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] colDir = {0, 0, -1, 1, -1, 1, 1, -1};

    public int findMaxArea(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    int size = dfs(visited, grid, i, j, m, n);
                    max = Math.max(max, size);
                }
            }
        }
        return max;
    }

    public int dfs(boolean[][] visited, int[][] grid, int r, int c, int m, int n)
    {
        visited[r][c] = true;
        int size = 1;

        for (int i = 0; i < 8; i++) {
            int newRow = r + rowDir[i];
            int newCol = c + colDir[i];

            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n 
                && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                size += dfs(visited, grid, newRow, newCol, m, n);
            }
        }
        
        return size;
    }
}
