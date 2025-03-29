class Solution {
  public int reverseDegree(String s) {
      int sum = 0;
      int n = s.length();
      for (int i = 0; i < n; i++) {
          char currentChar = s.charAt(i);
          int reverseValue = 26 - (currentChar - 'a');
          sum += reverseValue * (i + 1);

      }
      return sum;
  }
}