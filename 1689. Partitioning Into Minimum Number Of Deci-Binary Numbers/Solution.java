class Solution {
  public int minPartitions(String s) {
      int max = 0;
      int n = s.length();
      for (int i = 0; i < n; i++) {
          if (s.charAt(i) - '0' > max) {
              max = s.charAt(i) - '0';
          }
      }
      return max;
  }
}