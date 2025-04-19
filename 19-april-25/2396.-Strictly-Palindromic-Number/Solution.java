class Solution {
  public ArrayList<Integer> convert(int n, int b) {
      ArrayList<Integer> ls = new ArrayList<>();
      while (n > 0) {
          int d = n % b;
          n /= b;
          ls.add(d);
      }
      Collections.reverse(ls);
      return ls;
  }

  public boolean isStrictlyPalindromic(int n) {
      for (int i = 2; i <= n - 2; i++) {
          ArrayList<Integer> ls = convert(n, i);
          int left = 0;
          int right = ls.size() - 1;
          while (left < right) {
              if (ls.get(left) != ls.get(right)) {
                  return false;
              }
              left++;
              right--;
          }
      }
      return true;
  }
}

// Time Complexity: O(n log n)
// Space Complexity: O(log_b(n))