class Solution {
  public int[] pivotArray(int[] nums, int p) {
      int i = 0;
      int n = nums.length;
      int[] ans = new int[n];
      int idx = 0;
      int left = i;
      while (idx < n) {
          if (nums[idx] < p) {
              ans[i] = nums[idx];
              i++;
              left = i;
          }
          idx++;
      }

      i = n - 1;

      idx = n - 1;
      int right = i;
      while (idx >= 0) {
          if (nums[idx] > p) {
              ans[i] = nums[idx];
              i--;
              right = i;
          }
          idx--;
      }
      for (int k = left; k <= right; k++) {
          ans[k] = p;
      }
      return ans;
  }
}