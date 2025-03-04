class Solution {
  public int[] getSubarrayBeauty(int[] nums, int k, int x) {
      int l = 0, r = 0, n = nums.length;
      int res[] = new int[n - k + 1]; // Result array to store the beauty of each subarray
      int freq[] = new int[51]; // Frequency array to track negative numbers (0 to -50 as indices)

      // Initialize the frequency array with the first 'k' elements
      for (r = 0; r < k; r++) {
          if (nums[r] < 0) {
              freq[-nums[r]]++; // Store the absolute value of negative numbers
          }
      }

      int idx = 0;
      while (r < n) {
          // Get the xth smallest negative number in the current window
          res[idx++] = getSmallest(freq, x);

          // Remove the leftmost element from the frequency array if it was negative
          if (nums[l] < 0) {
              freq[-nums[l]]--;
          }
          l++; // Move the left pointer forward

          // Add the new rightmost element into the frequency array if it is negative
          if (nums[r] < 0) {
              freq[-nums[r]]++;
          }
          r++; // Move the right pointer forward
      }
      
      // Process the last window after the loop exits
      res[idx] = getSmallest(freq, x);
      
      return res;
  }

  // Function to find the xth smallest negative number from the frequency array
  public int getSmallest(int[] arr, int x) {
      int count = 0;
      for (int i = 50; i >= 0; i--) { // Iterate from most negative to least negative
          count += arr[i];
          if (count >= x) {
              return -i; // Convert back to negative
          }
      }
      return 0; // If there aren't enough negative numbers, return 0
  }
}
