class Solution {
  public int numSubarrayBoundedMax(int[] nums, int left, int right) {
      int ans = 0;
      int maxElement = Integer.MIN_VALUE;
      int l = 0;
      int r = 0;
      int n = nums.length;
      int prevcount = 0;
      while (r < n) {

          if (nums[r] > right) {
              prevcount = 0;
              l = r + 1;
          } else if (nums[r] >= left) {

              prevcount = r - l + 1;
              ans += prevcount;

          } else {

              ans += prevcount;
          }
          r++;
      }
      // ans += ((r - l) * (r - l + 1)) / 2;
      return ans;
  }
}