class Solution {
  public boolean canMakeSubsequence(String s, String p) {
      int i = 0;
      int j = 0;
      int n = s.length();
      int m = p.length();
      if(n<m)return false;
      while (i < n && j < m) {
          int pos1 = s.charAt(i) - 'a';
          int pos2 = p.charAt(j) - 'a';
          if (s.charAt(i) == p.charAt(j) || (pos1 + 1) % 26 == pos2) {
              i++;
              j++;
          } else {
              i++;
          }
          if ( n-i<m-j) {
              return false;
          }
      }

      return (j >= m);

  }
}

// Time Complexity (TC): O(n)
// Space Complexity (SC): O(1)