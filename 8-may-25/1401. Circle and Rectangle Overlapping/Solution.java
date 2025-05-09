class Solution {
  public boolean checkOverlap(int r, int xc, int yc, int x1, int y1, int x2, int y2) {
      int deltax = f(xc, x1, x2);
      int deltay = f(yc, y1, y2);

      return deltax * deltax + deltay * deltay <= r * r;
  }

  public int f(int v, int s, int e) {
      if (v >= s && v <= e)
          return 0;

      if (v < s) {
          return s - v;
      }
      return v - e;
  }
}