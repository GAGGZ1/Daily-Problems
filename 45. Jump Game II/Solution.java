class Solution {
  public int jump(int[] nums) {
      int ans = 0;
      int mx = 0;
      int lastjump = 0;
      int n = nums.length;
      for (int i = 0; i < n - 1; i++) {
          mx = Math.max(mx, i + nums[i]);
          if (i == lastjump) {
              ans++;
              lastjump = mx;

              if (mx >= n - 1)
                  break;
          }
      }
      return ans;
  }
}