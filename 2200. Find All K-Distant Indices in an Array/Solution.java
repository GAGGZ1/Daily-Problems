class Solution {
  public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
      int n = nums.length;
      Set<Integer> set = new HashSet<>();

      for (int i = 0; i < n; i++) {
          if (nums[i] == key) {
              int s = Math.max(i - k, 0);
              int e = Math.min(i + k, n - 1);
              for (int j = s; j <= e; j++) {
                  set.add(j);
              }
          }
      }

      List<Integer> result = new ArrayList<>(set);
      Collections.sort(result);
      return result;
  }
}
