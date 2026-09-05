class Solution {

    int[][] dir = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0, n, m);
            dfs(board, i, m - 1, n, m);
        }

        for (int j = 0; j < m; j++) {
            dfs(board, 0, j, n, m);
            dfs(board, n - 1, j, n, m);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } 
                else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, int n, int m) {

        if (i < 0 || i >= n ||
            j < 0 || j >= m ||
            board[i][j] != 'O') {
            return;
        }
        board[i][j] = '1';

        for (int k = 0; k < 4; k++) {
            int ni = i + dir[k][0];
            int nj = j + dir[k][1];

            dfs(board, ni, nj, n, m);
        }
    }
}