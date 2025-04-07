class Solution {
  public int[][] intervalIntersection(int[][] fl, int[][] sl) {
      List<int[]> result = new ArrayList<>();
      int i = 0;
      int j = 0;
      int n1 = fl.length;
      int n2 = sl.length;
      while (i < n1 && j < n2) {
          int s1 = fl[i][0];
          int e1 = fl[i][1];
          int s2 = sl[j][0];
          int e2 = sl[j][1];

          int maxs = Math.max(s1, s2);
          int mine = Math.min(e1, e2);

          if (maxs <= mine) {
              result.add(new int[] { maxs, mine });

          }
          if (e1 < e2) {
              i++;
          } else {
              j++;
          }

      }
      return result.toArray(new int[result.size()][]);
  }
}