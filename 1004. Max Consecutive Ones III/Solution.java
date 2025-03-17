class Solution {
  public int longestOnes(int[] nums, int k) {
      int left = 0;
      int right = 0;
      int count = 0;
      int max = 0;
      int n = nums.length;
      while (right < n) {
          if (nums[right] == 0) {
              count++;
          }

          while (count > k) {

              if (nums[left] == 0) {
                  count--;
              }
              left++;
          }
          max = Math.max(right - left + 1, max);
          right++;
      }
      return max;
  }
}