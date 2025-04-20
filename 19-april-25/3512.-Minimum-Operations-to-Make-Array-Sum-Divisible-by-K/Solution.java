class Solution {
  public int minOperations(int[] nums, int k) {
      int sum = 0;
      int n = nums.length;
      for (int i = 0; i < n; i++) {
          sum += nums[i];
      }

      return sum % k;
  }
}


// Time Complexity	O(n)
// Space Complexity O(1)