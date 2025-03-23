class Solution {
  public int numberOfSubarrays(int[] nums, int k) {
      int left = 0;
      int right = 0;
      int count = 0;
      int maxCount = 0;
      int sub = 0;
      int n = nums.length;
      while (right < n) {
          if (nums[right] % 2 != 0) {
              count++;
              sub = 0;
          }
          while (count == k) {
              if (nums[left] % 2 != 0) {
                  count--;

              }
              sub++;
              left++;

          }

          maxCount += sub;
          right++;
      }
      return maxCount;
  }
}