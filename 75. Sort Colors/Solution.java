class Solution {
  public void sortColors(int[] nums) {
      int s = 0;
      int m = 0;
      int n = nums.length;
      int e = n - 1;
      while (m <= e) {
          if (nums[m] == 1) {
              m++;
          } else if (nums[m] == 2) {
              int temp = nums[e];
              nums[e] = nums[m];
              nums[m] = temp;
              e--;
         
          } else {
              int temp = nums[s];
              nums[s] = nums[m];
              nums[m] = temp;
              m++;
              s++;
          }

      }
  }
}