class Solution {
  public int longestNiceSubarray(int[] nums) {
      int left = 0;
      int right = 0;
      int n = nums.length;
      int bitunion = 0;
      int max = 0;
      while (right < n) {
          if ((nums[right] & bitunion) == 0) {
              bitunion |= nums[right];
              max = Math.max(right - left + 1, max);
              right++;
          } else {
              bitunion &= ~nums[left];
              left++;
          }

      }
      return max;
  }
}