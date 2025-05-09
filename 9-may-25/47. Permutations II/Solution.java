class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] vis = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        solve(nums, new ArrayList<>(), res, vis);
        return res;
    }

    public void solve(int nums[], List<Integer> curr, List<List<Integer>> res, boolean[] vis) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) {
                continue;
            }
            if (!vis[i]) {

                vis[i] = true;
                curr.add(nums[i]);
                solve(nums, curr, res, vis);
                vis[i] = false;
                curr.remove(curr.size() - 1);
            }

        }
    }
}