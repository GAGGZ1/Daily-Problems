class Solution {
  public int compress(char[] chars) {
      int idx = 0;
      int i = 0;
      while (i < chars.length) {
          char currentChar = chars[i];
          int count = 0;
          while (i < chars.length && chars[i] == currentChar) {
              i++;
              count++;
          }
          chars[idx++] = currentChar;
          if (count > 1) {
              for (char c : String.valueOf(count).toCharArray()) {
                  chars[idx++] = c;
              }
          }
      }
      return idx;
  }
}


// Time Complexity	O(n)
// Space Complexity O(1)