class Solution {
  public int minSubArrayLen(int t, int[] nums) {
      int i = 0;
      int j = 0;
      int n = nums.length;
      if (n < 2) {
          if (nums[0] >= t) {
              return 1;
          } else {
              return 0;
          }
      }
      int cs = 0;
      int size = Integer.MAX_VALUE;
      while (j < n) {
          cs += nums[j];
          j++;// increase the window
          while (cs >= t) {
              size = Math.min(j - i, size);
              cs -= nums[i];
              i++;
          }

      }
      if (size == Integer.MAX_VALUE) {
          return 0;
      }
      return size;
  }
}