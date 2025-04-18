class Solution {

  public boolean validPalindrome(String s) {
      return vali(s, 0, s.length() - 1, false);
  }

  public boolean vali(String s, int i, int j, boolean skip) {
      while (i < j) {
          if (s.charAt(i) != s.charAt(j)) {
              if (skip) {
                  return false;
              }
              return vali(s, i + 1, j, true) || vali(s, i, j-1, true);
          }
          i++;
          j--;

      }
      return true;
  }
}

// Time Complexity: O(n)
// Space Complexity: O(n)