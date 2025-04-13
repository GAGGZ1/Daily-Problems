class Solution {
  public int wateringPlants(int[] p, int c) {
    int n = p.length;
    int s = 0;
    int cap = c;

    for (int i = 0; i < n; i++) {
      if (cap >= p[i]) {
        s++;
        cap -= p[i];

      } else {

        s = s + (((i) * 2) + 1);

        cap = c;

        cap -= p[i];

      }

    }

    return s;
  }
}