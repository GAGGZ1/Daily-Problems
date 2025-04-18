class Solution {
  public int[] shortestToChar(String s, char c) {
      ArrayList<Integer> ls = new ArrayList<>();
      for (int i = 0; i < s.length(); i++) {
          if (s.charAt(i) == c) {
              ls.add(i);
          }
      }
      int n = s.length();
      int[] ans = new int[n];
      for (int i = 0; i < n; i++) {
          int min = Integer.MAX_VALUE;
          for (int j = 0; j < ls.size(); j++) {
              min = Math.min(Math.abs(ls.get(j) - i), min);
          }
          ans[i] = min;
      }
      return ans;
  }
}


// Time Complexity: O(n × m)
// Space Complexity: O(n + m)



// =========================== optimised Code ========================


class Solution {
  public int[] shortestToChar(String s, char c) {
      int n = s.length();
      int[] ans = new int[n];
      int prev = -1;
      Arrays.fill(ans, Integer.MAX_VALUE);
      for (int i = 0; i < n; i++) {
          if (s.charAt(i) == c) {
              prev = i;
              ans[i] = 0;
          } else if (prev != -1) {
              ans[i] = i - prev;
          }
      }
      prev = -1;
      for (int i = n - 1; i >= 0; i--) {
          if (s.charAt(i) == c) {
              prev = i;
          } else if (prev != -1) {
              ans[i] = Math.min(ans[i], prev - i);
          }
      }
      return ans;

  }
}

// Time Complexity: O(n)
// Space Complexity: O(n)