class Solution {
  public long minimumSteps(String s) {

      long ans = 0;
      int l = 0;
      int r = 0;
      int n = s.length();
      while (r < n) {
          if (s.charAt(r) == '0') {
              ans += r - l;
              l++;
          }
          r++;
      }
      return ans;
  }
}


class Solution {
  public long minimumSteps(String s) {

      long ans = 0;
      int l = 0;
      int r = 0;
      int n = s.length();
      while (r < n) {
          if (s.charAt(r) == '0') {
              ans += r - l;
              l++;
          }
          r++;
      }
      return ans;
  }
}


// Time Complexity: O(n)
// Space Complexity: O(1)