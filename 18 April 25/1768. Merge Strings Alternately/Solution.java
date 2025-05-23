class Solution {
  public String mergeAlternately(String word1, String word2) {
      int i = 0;
      int j = 0;
      StringBuilder sb = new StringBuilder();
      int n = word1.length();
      int m = word2.length();
      while (i < n && j < m) {
          sb.append(word1.charAt(i));
          sb.append(word2.charAt(j));
          i++;
          j++;
      }
      while (i < n) {
          sb.append(word1.charAt(i));
          i++;
      }
      while (j < m) {
          sb.append(word2.charAt(j));
          j++;
      }
      return sb.toString();
  }
}


// Time Complexity: O(n + m)
// Space Complexity: O(n + m)
