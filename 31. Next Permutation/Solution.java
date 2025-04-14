class Solution {
  public void reverse(int[] nums, int s) {

      int n = nums.length;
      int e = n - 1;
      while (s < e) {
          int temp = nums[s];
          nums[s] = nums[e];
          nums[e] = temp;
          s++;
          e--;
      }
  }

  public void nextPermutation(int[] nums) {
      int found = -1;
      int n = nums.length;
      for (int i = n - 2; i >= 0; i--) {
          if (nums[i] < nums[i + 1]) {
              found = i;
              break;
          }
      }
      if (found == -1) {
          reverse(nums, 0);

      } else {
          for (int i = n - 1; i >= 0; i--) {
              if (nums[i] > nums[found]) {
                  int temp = nums[found];
                  nums[found] = nums[i];
                  nums[i] = temp;
                  reverse(nums, found + 1);
                  break;
              }
          }
      }
  }
}