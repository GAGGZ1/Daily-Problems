class Solution {
  public long minimumRemoval(int[] b) {
      Arrays.sort(b);
      int n = b.length;
      long tsum = 0;
      for (int i = 0; i < n; i++) {
          tsum += b[i];
      }
      long min = Long.MAX_VALUE;
      for (int i = 0; i < n; i++) {
          long keep = tsum - (long) (n - i) * b[i];
          min = Math.min(keep, min);
      }
      return min;
  }
}