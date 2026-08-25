class Solution {

    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid[0].length;
        int n = grid.length;
        boolean[][] visi = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visi[i][j] && grid[i][j] == '1') {
                    count++;
                    find(grid, i, j, n, m, visi);
                }
            }
        }
        return count;
    }

    public void find(char[][] grid, int i, int j, int n, int m, boolean[][] visi) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0' || visi[i][j]) {
            return;
        }
        visi[i][j] = true;
        //up
        //down
        //left
        //right
        find(grid, i - 1, j, n, m, visi);
        find(grid, i + 1, j, n, m, visi);
        find(grid, i, j - 1, n, m, visi);
        find(grid, i, j + 1, n, m, visi);

    }
}