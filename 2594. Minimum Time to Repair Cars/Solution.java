class Solution {
  public boolean isPossible(int[] ranks, int cars, long time) {
      int n = ranks.length;
      for (int i = 0; i < n; i++) {
          long curr = (int) Math.sqrt(time / ranks[i]);
          cars = (int) (cars - curr);
          if (cars <= 0)
              return true;
      }
      return false;
  }

  public long repairCars(int[] ranks, int cars) {
      Arrays.sort(ranks);
      long low = 0;
       int n = ranks.length;
      long high = ranks[0] * (long) cars * (long) cars;
      long ans = 0;
      while (low <= high) {
          long mid = low + (high - low) / 2;
          if (isPossible(ranks, cars, mid)) {
              ans = mid;
              high = mid - 1;
          } else {
              low = mid + 1;
          }
      }

      return ans;
  }
}