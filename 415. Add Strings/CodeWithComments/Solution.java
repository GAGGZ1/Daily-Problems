class Solution {
  public String addStrings(String num1, String num2) {
      // Initialize pointers to traverse both strings from the end (right to left)
      int i = num1.length() - 1;
      int j = num2.length() - 1;
      
      // Variable to store the carry from addition
      int c = 0;
      
      // StringBuilder to efficiently build the resulting sum string
      StringBuilder sb = new StringBuilder();

      // Loop until both numbers are completely processed or carry remains
      while (i >= 0 || j >= 0 || c > 0) {
          // Extract digits from num1 and num2; if out of bounds, assume 0
          int d1 = (i >= 0 ? num1.charAt(i) - '0' : 0);
          int d2 = (j >= 0 ? num2.charAt(j) - '0' : 0);

          // Compute the sum of the current digits and carry
          int sum = d1 + d2 + c;
          
          // Update carry for next iteration
          c = sum / 10;

          // Append last digit of sum to the result
          sb.append(sum % 10);

          // Move to the previous digits in both numbers
          i--;
          j--;
      }

      // Reverse the result to get the correct order and return as a string
      return sb.reverse().toString();
  }
}
