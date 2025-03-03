class Solution {
  public double findMaxAverage(int[] nums, int k) {
      int l = 0; // Left pointer for the sliding window
      int r = 0; // Right pointer for the sliding window

      // If the array length is smaller than k, return 0.0 (Edge case)
      if (nums.length < k)
          return 0.0;

      double sum = 0; // Variable to store the sum of elements in the current window

      // Compute the sum of the first k elements (Initial window)
      while (r < k) {
          sum += nums[r];
          r++;
      }

      double avg = sum / k; // Compute the average of the first window
      int n = nums.length;
      double max = avg; // Initialize max with the first window's average

      // Start sliding the window
      while (r < n) {
          // Remove the leftmost element from the window
          sum -= nums[l];
          l++; // Move left pointer

          // Add the new element at the right pointer to the window
          sum += nums[r];

          // Compute the new average
          avg = sum / k;

          // Update the maximum average found so far
          max = Math.max(avg, max);

          r++; // Move right pointer
      }

      return max; // Return the maximum average found
  }
}
