class Solution {
  public int maximumUniqueSubarray(int[] nums) {
      int l = 0;
      int r = 0;
      int maxSum = 0;
      int currSum = 0;
      int n = nums.length;
      HashSet<Integer> set = new HashSet<>();
      while (r < n) {

          while (set.contains(nums[r])) {
              currSum -= nums[l];
              set.remove(nums[l]);
              l++;
          }

          set.add(nums[r]);
          currSum += nums[r];
          maxSum = Math.max(currSum, maxSum);
          r++;
      }
      return maxSum;
  }
}