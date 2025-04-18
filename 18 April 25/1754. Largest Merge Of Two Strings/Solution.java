class Solution {
  public String largestMerge(String s, String p) {
      int n = s.length();
      int m = p.length();
      StringBuilder sb = new StringBuilder();
      int i = 0;
      int j = 0;
      while (i < n && j < m) {
          if (s.substring(i).compareTo(p.substring(j)) > 0) {
              sb.append(s.charAt(i));
              i++;
          } else {
              sb.append(p.charAt(j));
              j++;
          }
      }
      while (i < n) {
          sb.append(s.charAt(i));
          i++;
      }
      while (j < m) {
          sb.append(p.charAt(j));
          j++;
      }
      return sb.toString();
  }
}

// time complexity is O(n + m)
// space complexity is O(n + m).