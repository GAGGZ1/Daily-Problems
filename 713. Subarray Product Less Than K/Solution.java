class Solution {
  public int numSubarrayProductLessThanK(int[] nums, int k) {
      int left = 0;
      if (k <= 1)
          return 0;
      int right = 0;
      int n = nums.length;
      int product = 1;
      int ans = 0;
      while (right < n) {
          product *= nums[right];
          while (product >= k) {
              product /= nums[left];
              left++;
          }
          ans += right - left + 1;
          right++;
      }
      return ans;
  }
}