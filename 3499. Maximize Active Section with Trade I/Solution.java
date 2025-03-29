class Solution {
  public int maxActiveSectionsAfterTrade(String s) {
      int ans = 0;
      int maxlen = 0;
      int n = s.length();
      int[] suffix = new int[n];
      int[] prefix = new int[n];
      if (s.charAt(0) == '1') {
          prefix[0] = 1;
      } else {
          prefix[0] = 0;
      }
      if (s.charAt(n - 1) == '1') {
          suffix[n - 1] = 1;
      } else {
          suffix[n - 1] = 0;
      }
      int maxi = Math.max(prefix[0], suffix[n - 1]);
      for (int i = 1; i < n; i++) {
          if (s.charAt(i) == '1') {
              prefix[i] = 1 + prefix[i - 1];
          } else {
              prefix[i] = prefix[i - 1];
          }
          maxi = Math.max(maxi, prefix[i]);
      }
      for (int i = n - 2; i >= 0; i--) {
          if (s.charAt(i) == '1') {
              suffix[i] = 1 + suffix[i + 1];
          } else {
              suffix[i] = suffix[i + 1];
          }
          maxi = Math.max(maxi, suffix[i]);
      }

      int l = 0;
      while (l < n) {
          while (l < n && s.charAt(l) == '1')
              l++;
          if (l < n) {

              int r = l + 1;

              while (r < n && s.charAt(r) == '0')
                  r++;
              if (r == n)
                  break;
              while (r < n && s.charAt(r) == '1')
                  r++;
              if (r == n)
                  break;
              int prev = r;
              while (r < n && s.charAt(r) == '0')
                  r++;

              r--;
              int len = (r - l + 1) + prefix[l] + suffix[r];

              maxi = Math.max(maxi, len);
              l = prev;

          }
      }
      return maxi;

  }
}