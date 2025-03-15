class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        // Get the number of rows (n) and columns (m)
        int n = mat.length;
        int m = mat[0].length;
  
        // Define search space in a virtual 1D representation of the 2D matrix
        int low = 0;
        int high = m * n - 1;
  
        // Perform binary search
        while (low <= high) {
            int mid = (low + high) / 2;
  
            // Convert mid index into 2D matrix indices
            int row = mid / m;
            int col = mid % m;
  
            // Check if the target is found
            if (mat[row][col] == target) {
                return true;
            } 
            // If target is greater, search in the right half
            else if (mat[row][col] < target) {
                low = mid + 1;
            } 
            // If target is smaller, search in the left half
            else {
                high = mid - 1;
            }
        }
  
        // Target not found
        return false;
    }
  }
  