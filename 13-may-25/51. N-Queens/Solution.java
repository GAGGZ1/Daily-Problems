class Solution {
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';

            }
        }

        List<List<String>> res = new ArrayList<>();
        solve(board, n, 0, res);
        return res;
    }

    public void solve(char board[][], int n, int row, List<List<String>> res) {

        if (row == n) {
            List<String> curr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                curr.add(new String(board[i]));
            }
            res.add(curr);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isValid(row, j, board, n)) {
                board[row][j] = 'Q';
                solve(board, n, row + 1, res);
                board[row][j] = '.';
            }
        }
    }

    public boolean isValid(int i, int j, char board[][], int n) {

        //same col
        for (int k = 0; k < i; k++) {
            if (board[k][j] == 'Q') {
                return false;
            }
        }

        //left diagonal upper
        int k = i - 1;
        int l = j - 1;
        while (k >= 0 && l >= 0) {
            if (board[k][l] == 'Q') {
                return false;
            }
            k--;
            l--;
        }
        //right diagonal upper
        k = i - 1;
        l = j + 1;
        while (k >= 0 && l < n) {
            if (board[k][l] == 'Q') {
                return false;
            }
            k--;
            l++;
        }

        return true;

    }
}