class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' &&  !isSafe(board, i, j, board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSafe(char[][] board, int r, int c, char num) {

        for (int j = 0; j < 9; j++) {

            if (j != c && board[r][j] == num) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {

            if (i != r && board[i][c] == num) {
                return false;
            }
        }
        int newrow = r - r % 3;
        int newcol = c - c % 3;
        for (int i = newrow; i < newrow + 3; i++) {
            for (int j = newcol; j < newcol + 3; j++) {
                if ((i != r || j != c) && board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}

// Time Complexity: O(1) (constant time, because the size of the board is fixed at 9x9)

// Space Complexity: O(1)