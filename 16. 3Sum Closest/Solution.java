class Solution {
  public int threeSumClosest(int[] nums, int t) {
      int n = nums.length;
      Arrays.sort(nums);
      int c1 = nums[0] + nums[1] + nums[2];
      int ans = c1;
      c1 = Math.abs(c1 - t);
      for (int i = 0; i < n; i++) {
          int e1 = nums[i];
          int l = i + 1;
          int e = n - 1;
          while (l < e) {
              int sum = e1 + nums[l] + nums[e];
              if (Math.abs(sum - t) < c1) {
                  c1 = Math.abs(sum - t);
                  ans = sum;
              }

              if (sum < t) {
                  l++;
              } else if (sum > t) {
                  e--;
              } else {
                  return t;
              }
          }
      }
      return ans;
  }
}