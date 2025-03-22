class Solution {
  public int totalFruit(int[] nums) {
      int n = nums.length;
      int left = 0;
      int right = 0;
      int k = 2;
      int ans = 0;
      // HashSet<Integer> set = new HashSet<>(); // set.remove()
      HashMap<Integer, Integer> map = new HashMap<>();
      while (right < n) {
          map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
          while (map.size() > k) {
              map.put(nums[left], map.get(nums[left]) - 1);
              if (map.get(nums[left]) == 0) {
                  map.remove(nums[left]);
              }
              left++;
          }
          ans = Math.max(right - left + 1, ans);
          right++;
      }
      return ans;
  }

}
