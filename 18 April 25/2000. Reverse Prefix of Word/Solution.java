class Solution {
  public String reversePrefix(String word, char ch) {
      int r = -1;
      char[] s = word.toCharArray();
      int n = s.length;
      for (int i = 0; i < n; i++) {
          if (s[i] == ch) {
              r = i;
              break;
          }
      }
      if (r == -1) {
          return word;
      }
      int l = 0;

      while (l < r) {
          char temp = s[l];
          s[l] = s[r];
          s[r] = temp;
          l++;
          r--;
      }
      return new String(s);
  }

}


// Time Complexity: O(n)
// Space Complexity: O(n)