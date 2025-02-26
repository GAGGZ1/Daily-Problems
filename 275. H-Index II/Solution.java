class Solution {
  public int hIndex(int[] c) {
      int n = c.length;
      int s = 0, e = n - 1;
      while (s <= e) {
          int m = s + (e - s) / 2;
          if (c[m] == n - m) {
              return n - m;
          } else if (c[m] < n - m) {
              s = m + 1;
          } else {
              e = m - 1;
          }
      }
      return n - s;
  }
}
