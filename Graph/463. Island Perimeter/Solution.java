class Solution {

    int count = 0;

    int[][] dir = {
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 }
    };

    public int islandPerimeter(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1 && !visited[i][j]) {
                    solve(grid, i, j, visited);
                }
            }
        }

        return count;
    }

    public void solve(int[][] grid, int i, int j, boolean[][] visited) {

        int n = grid.length;
        int m = grid[0].length;

        if (i < 0 || i >= n ||
                j < 0 || j >= m ||
                visited[i][j] ||
                grid[i][j] == 0) {
            return;
        }

        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {

            int ni = i + dir[k][0];
            int nj = j + dir[k][1];
            if (ni < 0 || ni >= n ||
                    nj < 0 || nj >= m ||
                    grid[ni][nj] == 0) {

                count++;
            } else if (!visited[ni][nj]) {
                solve(grid, ni, nj, visited);
            }
        }
    }
}