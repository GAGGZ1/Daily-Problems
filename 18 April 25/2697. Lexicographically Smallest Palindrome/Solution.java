class Solution {
  public String makeSmallestPalindrome(String s) {
      int l = 0;
      int n = s.length();
      char[] arr = s.toCharArray();
      int r = n - 1;
      while (l < r) {
          if (arr[l] != arr[r]) {
              if (arr[l] < arr[r]) {
                  arr[r] = arr[l];
              } else {
                  arr[l] = arr[r];
              }

          }
          l++;
          r--;
      }
      return new String(arr);
  }
}


// Time Complexity: O(n)
// Space Complexity: O(n)