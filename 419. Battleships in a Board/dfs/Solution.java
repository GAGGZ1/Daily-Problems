class Solution {
  public int countBattleships(char[][] board) {

      int n = board.length;
      int m = board[0].length;
      int count = 0;

      for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
              if (board[i][j] == 'X') {
                  if (i > 0 && board[i - 1][j] == 'X') {
                      continue;
                  }
                  if (j > 0 && board[i][j - 1] == 'X') {
                      continue;
                  }
                  count++;

              }
          }
      }
      return count;
  }
}