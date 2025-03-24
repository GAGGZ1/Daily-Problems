class Solution {
  public int longestSubarray(int[] nums) {
      int n = nums.length;
      int r = 0;
      int l = 0;
      int max = 0;
      int curr = 0;
      int countZero = 0;
      while (r < n) {
          if (nums[r] == 0) {
              countZero++;
          }
          while (countZero > 1) {
              if (nums[l] == 0) {
                  countZero--;
              }
              l++;
          }
          
          curr = r - l + 1;
          max = Math.max(curr, max);
          r++;
      }
      return max - 1;
  }
}