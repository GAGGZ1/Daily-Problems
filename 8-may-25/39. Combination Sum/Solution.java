class Solution {
  public List<List<Integer>> combinationSum(int[] c, int t) {
      List<Integer> curr = new ArrayList<>();
      List<List<Integer>> res = new ArrayList<>();
      solve(c, t, 0, curr, res);
      return res;
  }

  public void solve(int[] nums, int t, int s, List<Integer> curr, List<List<Integer>> res) {
      if (t == 0) {
          res.add(new ArrayList<>(curr));
          return;
      }
     
      if (t < 0)
          return;
      for (int i = s; i < nums.length; i++) {
          // if (nums[i] == prev)
          //     continue;
          curr.add(nums[i]);
          solve(nums, t - nums[i],i, curr, res);
          curr.remove(curr.size() - 1);
      }
  }
}