class Solution {
  public List<List<Integer>> fourSum(int[] nums, int t) {
      Arrays.sort(nums);
      List<List<Integer>> ans = new ArrayList<>();
      int n = nums.length;
      for (int i = 0; i < n - 3; i++) {
          if (i > 0 && nums[i] == nums[i - 1])
              continue;
          for (int j = i + 1; j < n - 2; j++) {
              if (j > i + 1 && nums[j] == nums[j - 1])
                  continue;
              int s = j + 1;
              int e = n - 1;
              while (s < e) {
                  long sum = (long) nums[i] + (long) nums[j] + (long) nums[s] + (long) nums[e];
                  if (sum == t) {
                      List<Integer> ls = new ArrayList<>();
                      ls.add(nums[i]);
                      ls.add(nums[j]);
                      ls.add(nums[s]);
                      ls.add(nums[e]);
                      ans.add(ls);

                      while (s < e && nums[s] == nums[s + 1])
                          s++;
                      while (s < e && nums[e] == nums[e - 1])
                          e--;

                      s++;
                      e--;
                  } else if (sum < t) {
                      s++;
                  } else {
                      e--;
                  }
              }
          }
      }
      return ans;
  }
}