import java.util.*;
class Solution {
  public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
      List<Integer> ans = new ArrayList<>();
      solve(nums, 0, res, ans);
      return res;

  }

  public void solve(int[] n, int i, List<List<Integer>> res, List<Integer> ans) {
      if (i >= n.length) {
          res.add(new ArrayList<>(ans));

          return;
      }
      ans.add(n[i]);
      solve(n, i + 1, res, ans);
      ans.remove(ans.size() - 1);
      solve(n, i + 1, res, ans);

  }
}