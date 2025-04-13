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
//  ======= O(n) approach difference array =====
class Solution {
  public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
      List<Integer> ls = new ArrayList<>();
      int n = nums.length;
      int[] diff = new int[n + 1];
      for (int i = 0; i < n; i++) {
          if (nums[i] == key) {
              int s = Math.max(0, i - k);
              int e = Math.min(n, i + k + 1);
              diff[s]++;
              diff[e]--;
          }
      }
      int count = 0;
      for (int i = 0; i < n; i++) {
          count += diff[i];
          if (count > 0) {
              ls.add(i);
          }
      }
      return ls;
  }
}