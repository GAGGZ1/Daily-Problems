class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
      int start = 0;
      int totalgas = 0;
      int currgas = 0;
      int n = cost.length;
      for (int i = 0; i < n; i++) {
          int diff = gas[i] - cost[i];
          currgas += diff;
          totalgas += diff;
          if (currgas < 0) {
              currgas = 0;
              start = i + 1;

          }

      }
      return totalgas >= 0 ? start : -1;
  }
}