class Solution {
  public int longestSubarray(int[] nums, int limit) {
      int left = 0, right = 0, ans = 0;
      TreeMap<Integer, Integer> map = new TreeMap<>();

      while (right < nums.length) {

          map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

          while (map.lastKey() - map.firstKey() > limit) {
              map.put(nums[left], map.get(nums[left]) - 1);
              if (map.get(nums[left]) == 0) {
                  map.remove(nums[left]);
              }
              left++;
          }

          ans = Math.max(ans, right - left + 1);
          right++;
      }

      return ans;
  }
}
