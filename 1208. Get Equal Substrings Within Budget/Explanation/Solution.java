class Solution {
  public int equalSubstring(String s, String t, int maxcost) {
      int left = 0;  // Left pointer for the sliding window
      int right = 0; // Right pointer for the sliding window
      int currcost = 0; // Tracks the total cost of transforming the substring
      int n = s.length(); // Length of the input strings
      int maxlen = 0; // Stores the maximum valid substring length

      while (right < n) {
          // Calculate the cost of changing the current character in s to match t
          currcost += Math.abs(s.charAt(right) - t.charAt(right));

          // If cost exceeds maxcost, shrink the window from the left
          if (currcost > maxcost) {
              currcost -= Math.abs(s.charAt(left) - t.charAt(left)); // Remove leftmost cost
              left++; // Move left pointer forward
          }

          // Update the maximum valid substring length
          maxlen = Math.max(maxlen, right - left + 1);
          
          // Expand the window by moving the right pointer forward
          right++;
      }

      return maxlen; // Return the maximum length of the valid substring
  }
}
// Complexity Analysis
// Time Complexity: O(n), where n is the length of the input strings s and t.
// Space Complexity: O(1), as we are using a constant amount of space.