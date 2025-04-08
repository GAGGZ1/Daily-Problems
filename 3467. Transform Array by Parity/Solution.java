class Solution {
  public int[] transformArray(int[] nums) {
      int even = 0;
      int n = nums.length;
      for (int i = 0; i < n; i++) {
          if (nums[i] % 2 == 0) {
              even++;
          }
      }
      for (int i = 0; i < n; i++) {
          if (i < even) {
              nums[i] = 0;
          } else {
              nums[i] = 1;
          }
      }
      return nums;
  }
}