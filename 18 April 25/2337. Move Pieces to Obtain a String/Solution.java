class Solution {
  public boolean canChange(String s, String t) {

      int i = 0;
      int j = 0;
      int n = s.length();
      int m = s.length();
      while (i < n || j < m) {

          while (i < n && s.charAt(i) == '_')
              i++;
          while (j < n && t.charAt(j) == '_')
              j++;
          if (i == n && j == m)
              return true;
          if (i == n || j == m)
              return false;

          char c1 = s.charAt(i);
          char c2 = t.charAt(j);
          if (c1 != c2) {
              return false;
          }
          if (c1 == 'L' && i < j)
              return false;
          if (c2 == 'R' && j < i)
              return false;
          i++;
          j++;
      }
      return true;
  }
}

// Time Complexity: O(n)
// Space Complexity: O(1)