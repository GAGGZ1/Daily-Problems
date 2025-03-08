import java.util.Scanner; // Import Scanner class for user input

// Main class containing the solution
class Main {

  // Method to find the minimum possible difference between two subsets
  public static int minimumDifference(int[] nums) {
      int n = nums.length; // Get the length of the array
      // Call the recursive solve method to find the minimum difference
      return solve(nums, Integer.MAX_VALUE, 0, 0, 0, 0, 0, n / 2);
  }

  // Recursive function to explore all possible subset combinations
  public static int solve(int[] nums, int res, int i, int s1, int s2, int sum1, int sum2, int n) {
      // Base condition: if index exceeds array length
      if (i >= nums.length) {
          // Calculate absolute difference between two subsets
          int diff = Math.abs(sum1 - sum2);
          // Update result if current difference is smaller
          if (diff < res) {
              res = diff;
          }
          return res; // Return the minimum difference found
      }

      // Exploring the inclusion of the current element in the first subset
      int include = Integer.MAX_VALUE;
      if (s1 < n) { // Ensure subset 1 does not exceed half the total elements
          include = solve(nums, res, i + 1, s1 + 1, s2, sum1 + nums[i], sum2, n);
      }

      // Exploring the inclusion of the current element in the second subset
      int exclude = Integer.MAX_VALUE;
      if (s2 < n) { // Ensure subset 2 does not exceed half the total elements
          exclude = solve(nums, res, i + 1, s1, s2 + 1, sum1, sum2 + nums[i], n);
      }

      // Return the minimum difference between both possibilities
      return Math.min(include, exclude);
  }

  // Main method to accept user input and display the result
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); // Scanner object for user input
    System.out.println("Enter the number of elements in the array: ");
    int n = sc.nextInt(); // Input the number of elements

    int[] nums = new int[n]; // Array to hold the elements
    System.out.println("Enter the elements of the array: ");
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt(); // Input each element
    }
    
    // Calculate and display the minimum difference
    int result = minimumDifference(nums);
    System.out.println("The minimum difference is: " + result);
  }
}
