class Solution {
  public List<List<Integer>> combinationSum3(int k, int n) {
      List<List<Integer>> res = new ArrayList<>();
      solve(k, n, new ArrayList<>(), res, -1,1);
      return res;
  }

  public void solve(int k, int t, List<Integer> curr, List<List<Integer>> res, int prev,int s) {
      if (curr.size() == k && t == 0) {
          res.add(new ArrayList<>(curr));
          return;
      }
      if (curr.size() > k)
          return;
      if (t < 0)
          return;

      for (int i = s; i <= 9; i++) {
          if (prev != i) {
              curr.add(i);
              solve(k, t - i, curr, res, i,i+1);
              curr.remove(curr.size() - 1);
          }
      }
  }
}