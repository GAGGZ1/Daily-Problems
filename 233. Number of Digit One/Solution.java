class Solution {
  public int countDigitOne(int n) {
      String numStr = Integer.toString(n);
      int len = numStr.length();
      int[][][] dp = new int[len][2][len];
      for (int[][] r : dp) {
          for (int c[] : r) {
              Arrays.fill(c, -1);
          }
      }
      return solve(numStr, 0, 1, 0, dp);
  }

  public int solve(String s, int idx, int tight, int cnt, int[][][] dp) {
      if (idx == s.length()) {
          return cnt;
      }
      if (dp[idx][tight][cnt] != -1) {
          return dp[idx][tight][cnt];
      }
      int limit = (tight == 1) ? (s.charAt(idx) - '0') : 9;
      int ans = 0;
      for (int i = 0; i <= limit; i++) {
          int newTight = (tight == 1 && i == limit) ? 1 : 0;
          int newCnt = cnt + (i == 1 ? 1 : 0);
          ans += solve(s, idx + 1, newTight, newCnt, dp);
      }
      return dp[idx][tight][cnt] = ans;

  }
}