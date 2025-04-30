class Solution {
  public int[] getSumAbsoluteDifferences(int[] nums) {
      int n = nums.length;
      int l[] = new int[n + 1];
      int r[] = new int[n + 1];
      l[0] = 0;
      for (int i = 1; i <= n; i++) {
          l[i] = l[i - 1] + nums[i - 1];
      }
      r[n] = 0;
      for (int i = n - 1; i >= 0; i--) {
          r[i] = r[i + 1] + nums[i];
      }

      int ans[] = new int[n];
      for (int i = 0; i < n; i++) {
          ans[i] = (((i) * nums[i]) - l[i]) + (r[i + 1] - ((n - i - 1) * nums[i]));

      }

      return ans;
  }
}