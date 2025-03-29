class Solution {
  public int maximizeSum(int[] nums, int k) {
      Arrays.sort(nums);
      int score = 0;
      int num = nums[nums.length - 1];
      for (int i = 0; i < k; i++) {
          score += num;
          num = num + 1;
      }
      return score;
  }
}