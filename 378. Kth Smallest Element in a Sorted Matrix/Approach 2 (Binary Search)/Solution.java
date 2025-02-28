class Solution {
  // Helper function to count elements <= m in the matrix
  public int count(int[][] mat, int k, int m, int n) {
      int row = 0; // Start from the first row
      int col = n - 1; // Start from the last column
      int count = 0; // Count of elements ≤ m

      // Traverse the matrix from the top-right corner
      while (col >= 0 && row < n) {
          if (mat[row][col] <= m) {
              // If mat[row][col] is less than or equal to m,
              // then all elements in this row up to this column are ≤ m
              count += col + 1;
              row++; // Move to the next row
          } else {
              col--; // Move left in the same row
          }
      }
      return count; // Return the total count of elements ≤ m
  }

  // Main function to find the k-th smallest element in the sorted matrix
  public int kthSmallest(int[][] mat, int k) {
      int n = mat.length; // Size of the square matrix
      int s = mat[0][0]; // Smallest element in the matrix
      int e = mat[n - 1][n - 1]; // Largest element in the matrix
      int ans = 0; // Variable to store the final answer

      // Binary Search on the value range from `s` to `e`
      while (s <= e) {
          int m = s + (e - s) / 2; // Mid value of current search space

          // Count elements ≤ m in the matrix
          if (count(mat, k, m, n) < k) {
              s = m + 1; // If count is less than k, increase lower bound
          } else {
              ans = m; // If count is at least k, update answer
              e = m - 1; // Reduce the search space
          }
      }
      return ans; // Return the k-th smallest element
  }
}
// Total Time Complexity: O(n log(max-min))
// Space Complexity: O(1).