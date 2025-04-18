class Solution {
  public boolean areSentencesSimilar(String s, String t) {
      String[] word1 = s.split(" ");
      String[] word2 = t.split(" ");
      int n = word1.length;
      int m = word2.length;
      int l = 0;
      while (l < m && l < n && word1[l].equals(word2[l])) {
          l++;
      }
      int r1 = n - 1;
      int r2 = m - 1;
      while (r1 >= l && r2 >= l && word1[r1].equals(word2[r2])) {
          r1--;
          r2--;

      }
      if (m < n) {
          return (l > r2);
      }
      return (l > r1);

  }
}

// Time Complexity: O(n + m)
// Space Complexity: O(n + m)