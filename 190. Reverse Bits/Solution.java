public class Solution {
  // You need to treat n as an unsigned value
  public int reverseBits(int n) {
      int res = 0; // Initialize the result variable to store the reversed bits

      // Iterate through all 32 bits of the input integer
      for (int i = 0; i < 32; i++) {
          // Extract the least significant bit (rightmost bit) of n using bitwise AND
          int lastBit = n & 1;

          // Shift the result left by 1 to make space for the new bit
          res = (res << 1) | lastBit;

          // Right shift n by 1 to process the next bit
          // Use >>> (unsigned right shift) instead of >> to handle negative numbers
          // correctly
          n = n >> 1;
      }

      // Return the reversed bit representation as an integer
      return res;
  }
}
