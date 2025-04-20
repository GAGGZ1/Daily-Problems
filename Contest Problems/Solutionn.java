class Solution {
  public long[] resultArray(int[] nums, int k) {
    int n = nums.length;
    long[] res = new long[k];
    for (int i = 0; i < n; i++) {
      ps(nums, i, k, res);
    }
    return res;
  }

  public void ps(int[] n, int s, int k, long[] res) {
    long p = 1;
    for (int j = s; j < n.length; j++) {
      p = calMod(p, n[j], k);
      update(res, p);
    }
  }

  public long calMod(long p, int num, int k) {
    return (p * num) % k;
  }

  public void update(long[] res, long p) {
    res[(int) p]++;
  }
}