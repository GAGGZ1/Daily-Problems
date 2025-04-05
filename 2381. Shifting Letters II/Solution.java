class Solution {
  private char shiftChar(char c, int shift) {
      return (char) ('a' + ((c - 'a' + shift) % 26 + 26) % 26);
  }

  public String shiftingLetters(String s, int[][] shifts) {
      TreeMap<Integer, Integer> map = new TreeMap<>();

      for (int[] sh : shifts) {
          int u = sh[0];
          int v = sh[1];
          int d = sh[2];
          map.put(u, map.getOrDefault(u, 0) + (d == 0 ? -1 : 1));
          map.put(v + 1, map.getOrDefault(v + 1, 0) + (d == 0 ? 1 : -1));
      }
      ArrayList<int[]> ranges = new ArrayList<>();
      int st = -1;
      int sum = 0;
      for (int k : map.keySet()) {
          if (st == -1) {
              st = k;
              sum += map.get(k);
              continue;
          }
          ranges.add(new int[] { st, k - 1, sum });
          st = k;
          sum += map.get(k);
      }
      StringBuilder sb = new StringBuilder(s);
      for (int[] a : ranges) {
          int start = a[0];
          int j = a[1];
          int ch = a[2];
          for (int i = start; i <= j; i++) {
              sb.setCharAt(i, shiftChar(s.charAt(i), ch));
          }
      }
      return sb.toString();
  }
}