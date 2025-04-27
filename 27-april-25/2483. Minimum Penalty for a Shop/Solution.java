class Solution {
  public int bestClosingTime(String c) {
      int n = c.length();
      int p[] = new int[n + 1];
      int s[] = new int[n + 1];
      int cy = 0;
      int cn = 0;

      p[0] = 0;
      s[n] = 0;
      for (int i = 1; i <= n; i++) {
          if (c.charAt(i - 1) == 'N') {
              p[i] += 1;
          }
          p[i] += p[i - 1];

      }
      cn = 0;
      cy = 0;
      for (int i = n - 1; i >= 0; i--) {
          if (c.charAt(i) == 'Y') {
              s[i] += 1;
          }

          s[i] += s[i + 1];

      }
      int idx = 0;
      int min = Integer.MAX_VALUE;
      for (int i = 0; i <= n; i++) {
          if (min > (p[i] + s[i])) {
              idx = i;
              min = (p[i] + s[i]);
          }
      }
      return idx;

  }
}