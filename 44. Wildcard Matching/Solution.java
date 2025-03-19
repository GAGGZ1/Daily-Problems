// //////////// Two Pointer with Greedy //////////////
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
  public boolean isMatch(String s, String p) {
      int pPtr = 0;
      int sPtr = 0;
      int starIdx = -1;
      int matchIdx = -1;
      while (sPtr < s.length()) {
          if (pPtr < p.length() && (s.charAt(sPtr) == p.charAt(pPtr) || p.charAt(pPtr) == '?')) {
              sPtr++;
              pPtr++;

          } else if (pPtr < p.length() && p.charAt(pPtr) == '*') {
              starIdx = pPtr;

              matchIdx = sPtr;
              pPtr++;
          } else if (starIdx != -1) {
              pPtr = starIdx + 1;
              matchIdx++;
              sPtr = matchIdx;

          } else {
              return false;

          }

      }
      while (pPtr < p.length() && p.charAt(pPtr) == '*') {

          pPtr++;

      }

      return pPtr == p.length();

  }
}


// //////////// Dynamic Programming //////////////  
// Time Complexity: O(n*m)
// Space Complexity: O(n*m)
class Solution {
  public boolean isMatch(String s, String p) {
      Integer[][] dp = new Integer[s.length() + 1][p.length() + 1];

      return solve(s, p, 0, 0, dp);
  }

  public boolean solve(String s, String p, int i, int j, Integer[][] dp) {
      // base cases
      if (i == s.length() && j == p.length())
          return true;
      if (j == p.length())
          return false;
      if (i == s.length()) {
          while (j < p.length() && p.charAt(j) == '*') {
              j++;
          }
          return j == p.length();
      }
      if (dp[i][j] != null) {
          return dp[i][j] == 1;
      }

      // matching chars
      boolean result = false;
      if (i < s.length() && j < p.length() &&
              (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
          result = solve(s, p, i + 1, j + 1, dp);
      }

      // logic
      if (j < p.length() && p.charAt(j) == '*') {
          result = (solve(s, p, i, j + 1, dp) || solve(s, p, i + 1, j, dp));
      }
      dp[i][j] = result ? 1 : 0;
      return result;
  }
}