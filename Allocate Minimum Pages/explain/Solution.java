public class Solution {
  // Function to check if it's possible to allocate books with a given max pages `m`
  public static boolean possible(int arr[], int n, int k, int m) {
      int s = 1; // Number of students required (start with 1)
      int sum = 0; // Sum of pages allocated to current student
      
      for (int i = 0; i < n; i++) {
          // If adding current book pages doesn't exceed max allowed pages `m`
          if ((sum + arr[i]) <= m) {
              sum += arr[i]; // Assign book to current student
          } else {
              // Allocate to a new student
              s++;
              sum = arr[i]; // Start new student's book count with current book
          }

          // If students required exceed `k`, return false (not possible)
          if (s > k) {
              return false;
          }
      }
      return true; // Allocation is possible with given `m`
  }

  // Function to find the minimum possible max pages assigned to a student
  public static int findPages(int[] arr, int k) {
      int n = arr.length;

      // If there are more students than books, allocation is impossible
      if (k > n) {
          return -1;
      }

      int s = Integer.MIN_VALUE; // Lower bound: Max book pages (worst case, 1 book per student)
      int e = 0; // Upper bound: Sum of all pages (all books given to one student)
      int ans = Integer.MAX_VALUE; // To store the best (minimum max) result

      // Calculate `s` (max single book pages) and `e` (sum of all pages)
      for (int a : arr) {
          s = Math.max(a, s); // Maximum pages in a single book
          e += a; // Sum of all book pages
      }

      // Binary search to find the optimal maximum number of pages per student
      while (s <= e) {
          int m = s + (e - s) / 2; // Midpoint (potential answer)

          if (possible(arr, n, k, m)) {
              ans = m; // Store possible answer
              e = m - 1; // Try to find a smaller maximum allocation
          } else {
              s = m + 1; // Increase allowed pages per student
          }
      }

      return ans; // Return the minimum of maximum pages possible
  }

  public static void main(String[] args) {
      int[] arr = {12, 34, 67, 90};
      int k = 2; // Number of students
      System.out.println(findPages(arr, k)); // Expected output: 113
  }
}
