class Solution {
  public int characterReplacement(String s, int k) {
      int l = 0;
      int r = 0;
      int n = s.length();
      int maxfreq = 0;
      int maxlen = 0;
      HashMap<Character, Integer> map = new HashMap<>();
      while (r < n) {
          char cc = s.charAt(r);
          map.put(cc, map.getOrDefault(cc, 0) + 1);
          maxfreq = Math.max(maxfreq, map.get(cc));
          while (r - l - maxfreq + 1 > k) {
              char left = s.charAt(l);
              map.put(left, map.get(left) - 1);
              l++;

          }
          maxlen = Math.max(maxlen, r - l + 1);
          r++;
      }
      return maxlen;
  }
}