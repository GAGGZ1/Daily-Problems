class Solution {
  public int minimumRefill(int[] p, int a, int b) {
      int n = p.length;
      int ca = a;
      int cb = b;

      int s = 0;
      int e = n - 1;
      int ans = 0;
      while (s < e) {
          if (p[s] > ca) {
              ca = a;
              ans++;
          }
          ca -= p[s];
          s++;

          if (p[e] > cb) {
              cb = b;
              ans++;
          }
          cb -= p[e];
          e--;
      }
      if (s == e) {
          if (p[s] > ca && p[s] > cb) {
              ans++;
          }
      }
      return ans;
  }
}