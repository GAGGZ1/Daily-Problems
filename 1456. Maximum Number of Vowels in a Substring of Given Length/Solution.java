class Solution {
  public int maxVowels(String s, int k) {
      int l = 0; // Left pointer of the sliding window
      int r = 0; // Right pointer of the sliding window
      int n = s.length(); // Length of the string
      int ans = 0; // Variable to store the maximum number of vowels in any substring of length k
      int count = 0; // Counter to keep track of the number of vowels in the current window

      while (r < n) {
          // Get the current character at the right pointer
          char ch = s.charAt(r);

          // If the current character is a vowel, increase the count
          if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
              count++;
          }

          // If the window size exceeds k, remove the leftmost element from the window
          if (r - l + 1 > k) {
              ch = s.charAt(l); // Get the character at the left pointer
              // If the leftmost character is a vowel, decrease the count
              if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                  count--;
              }
              l++; // Move the left pointer to maintain window size k
          }

          // If the window size is exactly k, update the maximum vowel count found so far
          if (r - l + 1 == k) {
              ans = Math.max(ans, count);
          }

          r++; // Move the right pointer to expand the window
      }
      return ans; // Return the maximum number of vowels found in any substring of length k
  }
}
