class Solution {
  public long countGood(int[] nums, int k) {
      int l = 0;
      int r = 0;
      long n = nums.length;
      long pairCount = 0;
      HashMap<Integer, Integer> map = new HashMap<>();
      long ans = 0;
      while (r < n) {
          map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
          pairCount += map.get(nums[r]) - 1;

          while (pairCount >= k) {
              ans += n - r;
              map.put(nums[l], map.get(nums[l]) - 1);
              pairCount -= map.get(nums[l]);
              l++;

          }
          r++;

      }
      return ans;

  }
}