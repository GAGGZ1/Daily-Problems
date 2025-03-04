class Solution {
  public int numOfSubarrays(int[] arr, int k, int t) {
      int l = 0; // Left pointer for the sliding window
      int r = 0; // Right pointer for the sliding window
      int sum = 0; // Variable to store the sum of elements in the current window
      int count = 0; // Count of valid subarrays
      int n = arr.length; // Length of the input array

      // Traverse the array using the right pointer
      while (r < n) {
          sum += arr[r]; // Add the current element to the window sum

          // If the window size exceeds 'k', remove the leftmost element
          if (r - l + 1 > k) {
              sum -= arr[l]; // Remove the element going out of the window
              l++; // Move the left pointer forward
          }

          // Check if the window size is exactly 'k' and its average is >= t
          if ((sum / k) >= t && (r - l + 1 == k)) {
              count++; // Increment count if condition is met
          }

          r++; // Move the right pointer forward
      }

      return count; // Return the count of valid subarrays
  }
}
