import java.util.*;

class Solution {
  // Function to check if it's possible to place k cows with at least 'm' distance apart
  public static boolean possible(int[] arr, int m, int k) {
      int count = 1;  // Placing the first cow at the first position
      int pos = arr[0];  // Position of the last placed cow
      int n = arr.length;

      // Iterate through the stalls
      for (int i = 1; i < n; i++) {
          if (arr[i] - pos >= m) {  // If the difference is at least 'm'
              count++;  // Place the cow
              pos = arr[i];  // Update the last placed cow's position
          }
          if (count >= k) return true;  // If we placed all k cows, return true
      }
      return false;  // If not enough cows could be placed, return false
  }

  // Function to find the largest minimum distance between cows
  public static int aggressiveCows(int[] arr, int k) {
     Arrays.sort(arr);  // Sort the stall positions
     int n = arr.length;
     int ans = 0;
     int s = 1;  // Minimum possible distance (smallest non-zero gap)
     int e = arr[n - 1] - arr[0];  // Maximum possible distance (first to last stall)

     // Binary search for the maximum minimum distance
     while (s <= e) {
         int m = s + (e - s) / 2;  // Middle value for binary search
         if (possible(arr, m, k)) {  // Check if we can place cows with at least 'm' distance
             ans = m;  // Update answer
             s = m + 1;  // Try for a larger minimum distance
         } else {
             e = m - 1;  // Try for a smaller minimum distance
         }
     }
     return ans;  // Return the largest minimum distance possible
  }
}
