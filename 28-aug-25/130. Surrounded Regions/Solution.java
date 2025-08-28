class Solution {
    public void solve(char[][] b) {

        if (b == null || b.length == 0)
            return;
        int rows = b.length;
        int cols = b[0].length;
        // 1. left and right border
        for (int i = 0; i < rows; i++) {
            if (b[i][0] == 'O') {
                dfs(b, i, 0);
            }
            if (b[i][cols - 1] == 'O') {
                dfs(b, i, cols - 1);
            }
        }
        //2. top and down
        for (int j = 0; j < cols; j++) {
            if (b[0][j] == 'O') {
                dfs(b, 0, j);
            }
            if (b[rows - 1][j] == 'O') {
                dfs(b, rows - 1, j);
            }
        }
        // 3.Flip the remaining 'O's to 'X's and revert '#' back to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (b[i][j] == 'O') {
                    b[i][j] = 'X';
                } else if (b[i][j] == '#') {
                    b[i][j] = 'O';
                }
            }
        }

    }

    public void dfs(char[][] b, int r, int c) {
        int rows = b.length;
        int cols = b[0].length;
        if (r < 0 || r >= rows || c < 0 || c >= cols || b[r][c] != 'O') {
            return;
        }
        b[r][c] = '#';
        dfs(b, r + 1, c);
        dfs(b, r - 1, c);
        dfs(b, r, c + 1);
        dfs(b, r, c - 1);

    }
}
// Logic:
// 1️⃣ Mark all 'O's connected to border as '#' (DFS).
// 2️⃣ Flip remaining 'O' → 'X' (captured).
// 3️⃣ Flip '#' back to 'O' (safe).