class Solution {
  public int maxArea(int[] nums) {
      int l = 0;
      int n = nums.length;
      int r = n - 1;
      int max = -1;
      while (l < r) {
          if (nums[l] < nums[r]) {
              int curr = (r - l) * nums[l];
              max = Math.max(curr, max);
              l++;
          } else {
              int curr = (r - l) * nums[r];
              max = Math.max(curr, max);
              r--;
          }
      }
      return max;
  }
}