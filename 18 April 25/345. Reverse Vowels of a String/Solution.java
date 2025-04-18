class Solution {
  public boolean vow(char s) {
      if ("aeiouAEIOU".indexOf(s) == -1) {
          return false;
      }
      return true;
  }

  public String reverseVowels(String s) {
      int n = s.length();
      int l = 0;
      int r = n - 1;
      char[] arr = s.toCharArray();
      while (l < r) {
          while (l < r && !vow(arr[l])) {
              l++;
          }
          while (l < r && !vow(arr[r])) {
              r--;
          }
          char temp = arr[l];
          arr[l] = arr[r];
          arr[r] = temp;
          l++;
          r--;
      }
      return new String(arr);
  }
}

// Time Complexity: O(n)
// Space Complexity: O(n)