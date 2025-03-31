class Solution {
  public static boolean pali(String str) {
      StringBuilder rev = new StringBuilder(str).reverse();
      return str.equals(rev.toString());
  }
  public int longestPalindrome(String s, String t) {
      int maxlen = -1;
      int n = s.length();
      int m = t.length();
      ArrayList<String> strs = new ArrayList<>();
      for (int i = 0; i < n; i++) {
          for (int j = i + 1; j <= n; j++) {
              strs.add(s.substring(i, j));
          }
      }
      strs.add("");
      ArrayList<String> strt = new ArrayList<>();
      for (int k = 0; k < m; k++) {
          for (int l = k + 1; l <= m; l++) {
              strt.add(t.substring(k, l));
          }
      }
      strt.add("");
      for (String str1 : strs) {
          for (String str2 : strt) {
              String finalStr = str1 + str2;
              if (pali(finalStr)) {
                  maxlen = Math.max(maxlen, finalStr.length());
              }
          }
      }
      return maxlen;
  }
}