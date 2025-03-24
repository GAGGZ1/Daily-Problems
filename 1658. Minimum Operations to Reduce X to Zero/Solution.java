class Solution {
  public int minOperations(int[] nums, int x) {
      int r = 0;
      int l = 0;
      int currSum = 0;
      int target = 0;
      int n = nums.length;
      int maxLength = -1;
      int totalSum = 0;
      for (int i = 0; i < n; i++) {
          totalSum += nums[i];
      }
      target = totalSum - x;

      while ( r < n) {
          currSum += nums[r];

          while (l<=r && currSum > target) {
              currSum -= nums[l];
              l++;
          }

          if (currSum == target) {
              maxLength = Math.max(maxLength, r - l + 1);
          }

          r++;

      }
      if (maxLength != -1) {
          return n - maxLength;
      }
      return -1;
  }
}