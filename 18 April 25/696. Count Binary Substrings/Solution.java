class Solution {
  public int countBinarySubstrings(String s) {
      ArrayList<Integer> ls = new ArrayList<>();
      int i = 0;
      int n = s.length();
      int count = 0;
      while (i < n) {
          count = 1;
          while (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
              i++;
              count++;
          }

          ls.add(count);
          i++;
      }
      int ans = 0;
      for (int j = 1; j < ls.size(); j++) {
          ans += Math.min(ls.get(j - 1), ls.get(j));

      }
      return ans;
  }
}


// Time Complexity (TC): O(n)
// Space Complexity (SC): O(n)