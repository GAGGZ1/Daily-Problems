class Solution {
  public int maxScore(int[] arr, int k) {
      int leftsum = 0;
      int n = arr.length;
      for (int i = 0; i <= k - 1; i++) {
          leftsum += arr[i];
      }
      int maxsum = leftsum;
      int idx = n - 1;
      int rightsum = 0;
      for (int i = k - 1; i >= 0; i--) {
          leftsum -= arr[i];
          rightsum += arr[idx];
          idx--;
          maxsum = Math.max(leftsum + rightsum, maxsum);

      }
      return maxsum;

  }
}