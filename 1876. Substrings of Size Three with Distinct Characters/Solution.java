class Solution {
  public int countGoodSubstrings(String s) {
      HashSet<Character> set = new HashSet<>();
      int l = 0;
      int r = 0;
      int k = 3;
      int ans = 0;
      int n = s.length();
      if (n < 3)
          return 0;
      while (r < n) {
          if (!set.contains(s.charAt(r))) {
              set.add(s.charAt(r));
              r++;

              if (r - l == k) {
                  ans++;
                  set.remove(s.charAt(l));
                  l++;
              }

          } else {
              set.remove(s.charAt(l));
              l++;
          }

      }
      return ans;
  }
}