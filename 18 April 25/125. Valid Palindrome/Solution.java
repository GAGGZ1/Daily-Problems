class Solution {
  public boolean isPalindrome(String s) {
      int l = 0;
      int n = s.length();
      s = s.toLowerCase();
      int r = n - 1;
      while (l < r) {
          while (l < r && !Character.isLetterOrDigit(s.charAt(l)))
              l++;
          while (l < r && !Character.isLetterOrDigit(s.charAt(r)))
              r--;
          if (s.charAt(l) != s.charAt(r)) {
              return false;
          }
          l++;
          r--;
      }
      return true;
  }
}

// Time Complexity: O(n)
// Space Complexity: O(n)