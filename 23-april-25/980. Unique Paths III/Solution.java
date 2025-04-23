class Solution {
    private int count = 0;
    private int maxvis = 0;

    public int uniquePathsIII(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean vis[][] = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (grid[i][j] == 1 || grid[i][j] == 0) {
                    maxvis++;
                }
            }
        }
        int currvis = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (grid[i][j] == 1) {
                    solve(grid, i, j, r, c, vis, currvis);
                }
            }
        }
        return count;

    }

    public void solve(int[][] grid, int i, int j, int r, int c, boolean[][] vis, int currvis) {

        if (grid[i][j] == 2 && currvis == maxvis) {
            count += 1;
            return;
        }

        vis[i][j] = true;
        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        for (int k = 0; k < 4; k++) {
            int newi = dir[k][0] + i;
            int newj = dir[k][1] + j;
            if (newi < r && newi >= 0 && newj < c && newj >= 0 &&
                    (grid[newi][newj] == 0 || grid[newi][newj] == 2) && !vis[newi][newj]) {
                solve(grid, newi, newj, r, c, vis, currvis + 1);
            }

        }

        vis[i][j] = false;

    }
}

//  time complexity is O(r * c * 4^(r * c))
//  space complexity is O(r * c) 