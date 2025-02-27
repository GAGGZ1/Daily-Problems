class Solution {
  public int[] productExceptSelf(int[] nums) {
      int n = nums.length;

      // Step 1: Compute the left (prefix) product array
      int left[] = new int[n]; // Array to store the product of elements before index i
      left[0] = 1; // There is nothing before index 0, so initialize it as 1

      for (int i = 1; i < n; i++) {
          left[i] = left[i - 1] * nums[i - 1]; // Store product of all elements before i
      }

      // Step 2: Compute the right (suffix) product array
      int[] right = new int[n]; // Array to store the product of elements after index i
      right[n - 1] = 1; // There is nothing after the last index, so initialize it as 1

      for (int i = n - 2; i >= 0; i--) {
          right[i] = right[i + 1] * nums[i + 1]; // Store product of all elements after i
      }

      // Step 3: Multiply left and right product arrays to get the final result
      for (int i = 0; i < n; i++) {
          left[i] = left[i] * right[i]; // Each index will have the product except itself
      }

      // Return the final result array
      return left;
  }
}
