import java.util.*;
class Solution {
  public int lengthOfLongestSubstring(String s) {
      int i = 0;
      int j = 0;
      int n = s.length();
      if (n < 2) {
          return n;
      }
      int max = 0;
      HashSet<Character> set = new HashSet<>();

      while (j < n) {
          if (!set.contains(s.charAt(j))) {
              max = Math.max(j - i + 1, max);
              set.add(s.charAt(j));
              j++;
          } else {

              set.remove(s.charAt(i));
              i++;

          }

      }
      return max;
  }
}