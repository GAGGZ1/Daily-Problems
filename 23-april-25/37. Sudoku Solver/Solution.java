class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {
        int newrow = -1;
        int newcol = -1;
        boolean flag = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    newrow = i;
                    newcol = j;
                    flag = false;
                    break;
                }
            }
            if(!flag){
                break;
            }
        }
        if (flag) {
            return true;
        }

        for (int i = 1; i <= 9; i++) {
            if (isSafe(board, newrow, newcol, i)) {
                board[newrow][newcol] = (char) (i+'0');
                if (solve(board)) {
                    return true;
                }
                board[newrow][newcol] = '.';
            }
        }
        return false;
    }

    public boolean isSafe(char[][] board, int r, int c, int num) {

        for (int i = 0; i < 9; i++) {
            if (board[r][i] - '0' == num) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][c] - '0' == num) {
                return false;
            }
        }
        int newrow = r - r % 3;
        int newcol = c - c % 3;
        for (int i = newrow; i < newrow + 3; i++) {
            for (int j = newcol; j < newcol + 3; j++) {
                if (board[i][j] - '0' == num) {
                    return false;
                }
            }
        }
        return true;
    }
}



// Time Complexity :	O(9^k), k ≤ 81
// Space Complexity :	O(k) (recursion)