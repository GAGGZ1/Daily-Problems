class Solution {
  public long calculateScore(String[] ins, int[] values) {
      int n = values.length;
      boolean[] vis = new boolean[n];
      long score = 0;

      int i = 0;
      while (i >= 0 && i < n) {

          if (!vis[i]) {
              vis[i] = true;
              if (ins[i].equals("add")) {
                  score += values[i];
                  i++;
              } else {
                  i = i + values[i];
              }
          } else {
              break;
          }
      }

      return score;
  }
}


// Time Complexity: O(n)
// Space Complexity: O(n)