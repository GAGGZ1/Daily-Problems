class Solution {
  public int maxFrequency(int[] nums, int k) {
      Arrays.sort(nums);
      long currSum = 0;
      int l = 0;
      int r = 0;
      int n = nums.length;
      // int targetSum = 0;
      int maxFreq = 0;
      while (r < n) {
          currSum +=  nums[r];

          while (l <= r && currSum + k < (long) nums[r] * (r - l + 1)) {
              currSum -= nums[l];
              l++;

          }

          maxFreq = Math.max((r - l + 1), maxFreq);

          r++;
      }
      return maxFreq;
  }
}