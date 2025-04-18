class Solution {
  public String reverseWords(String s) {
      int i = 0;
      StringBuilder sb = new StringBuilder();
      StringBuilder res = new StringBuilder();
      int n = s.length();
      while (i < n) {
          sb.setLength(0);
          while (i < n && s.charAt(i) != ' ') {
              sb.append(s.charAt(i));
              i++;
          }
          sb.reverse();
          res.append(sb);
          if(i<n)
          res.append(" ");
          i++;
      }
      // res.setLength(res.length() - 1);
      return res.toString();
  }
}

// Time Complexity (TC): O(n)
// Space Complexity (SC): O(n)