class Solution {
  public String smallestPalindrome(String s) {
      int[] freq = new int[26];
      for (char c : s.toCharArray()) {
          freq[c - 'a']++;
      }

      int n = s.length();
      StringBuilder half = new StringBuilder();
      char mid = 0;

      for (int i = 0; i < 26; i++) {
          if (freq[i] % 2 == 1) {
              mid = (char) ('a' + i);
              freq[i]--;
              break;
          }
      }

      for (int i = 0; i < 26; i++) {
          int count = freq[i] / 2;
          char ch = (char) ('a' + i);
          for (int j = 0; j < count; j++) {
              half.append(ch);
          }
      }

      String firstHalf = half.toString();
      String secondHalf = new StringBuilder(firstHalf).reverse().toString();
      if (n % 2 == 1) {
          return firstHalf + mid + secondHalf;
      } else {
          return firstHalf + secondHalf;
      }
  }
}

// Time Complexity: O(n)
// Space Complexity: O(n)