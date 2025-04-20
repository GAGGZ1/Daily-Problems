class Solution {
  public long[] resultArray(int[] nums, int k) {
      long[] ans = new long[k];
      int n = nums.length;
      for (int i = 0; i < n; i++) {
          nums[i] %= k;
      }
      
      for (int i = 0; i < k; i++) {
          long[][]dp=new long[n][k+1];
          for(long []d:dp){
              Arrays.fill(d,Long.MAX_VALUE);
          }
          ans[i] = solve(0, -1, i, nums, k,dp);
      }
      return ans;
  }

  public long solve(int i, int prod, int target,
          int[] nums, int k, long[][] dp) {
      if (i == nums.length) {
          return 0;
      }
      if (dp[i][prod + 1] != Long.MAX_VALUE) {
          return dp[i][prod + 1];
      }
      long take = 0;
      long count = 0;
      long skip = 0;
      if (prod == -1) {
          if (nums[i] % k == target) {
              count = 1;
          }
          take = count + solve(i + 1, nums[i], target,
                  nums, k,dp);
          skip = solve(i + 1, -1, target, nums, k,dp);
      } else {
          long newprod = (nums[i] * prod) % k;
          if (newprod == target) {
              count = 1;
          }
          take = count + solve(i + 1, (int)newprod, target,
                  nums, k,dp);

      }
      return dp[i][prod+1] = take + skip;

  }
}

// Time Complexity (TC): O(k^2 * n)
// Space Complexity (SC): O(n * k)