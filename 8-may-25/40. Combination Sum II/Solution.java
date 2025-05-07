class Solution {
  public List<List<Integer>> combinationSum2(int[] c, int t) {
      Arrays.sort(c);

      List<List<Integer>> res = new ArrayList<>();
      solve(c, t, new ArrayList<>(), res, 0);
      return res;
  }

  public void solve(int[] nums, int t, List<Integer> curr, List<List<Integer>> res, int s) {
      if (t == 0) {
          res.add(new ArrayList<>(curr));
          return;
      }
      if (t < 0) {
          return;
      }
      for (int i = s; i < nums.length; i++) {
          if (i > s && nums[i] == nums[i - 1])
              continue;
          curr.add(nums[i]);
          solve(nums, t - nums[i], curr, res, i + 1);
          curr.remove(curr.size() - 1);
      }
  }
}