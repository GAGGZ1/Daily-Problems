class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int n = nums1.length;
      int m = nums2.length;
      
      // Ensure nums1 is the smaller array for efficient binary search
      if (n > m) {
          return findMedianSortedArrays(nums2, nums1);
      }
      
      int low = 0;
      int high = n;
      int total = n + m;
      
      while (low <= high) {
          int mid = low + (high - low) / 2; // Mid index for binary search in nums1
          int leftelements = (total + 1) / 2 - mid; // Number of elements needed from nums2 to balance the partition
          
          // Left and right boundary elements
          int l1 = Integer.MIN_VALUE; // Left element from nums1
          int l2 = Integer.MIN_VALUE; // Left element from nums2
          int r1 = Integer.MAX_VALUE; // Right element from nums1
          int r2 = Integer.MAX_VALUE; // Right element from nums2
          
          // Assign valid values to left boundary elements if they exist
          if (mid > 0) {
              l1 = nums1[mid - 1];
          }
          if (leftelements > 0) {
              l2 = nums2[leftelements - 1];
          }
          
          // Assign valid values to right boundary elements if they exist
          if (mid < n) {
              r1 = nums1[mid];
          }
          if (leftelements < m) {
              r2 = nums2[leftelements];
          }
          
          // Check if the partition is correct
          if (l1 <= r2 && l2 <= r1) {
              // If total elements are odd, median is the max of left elements
              if (total % 2 == 1) {
                  return Math.max(l1, l2);
              } else {
                  // If total elements are even, median is the average of max left and min right
                  return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
              }
          } 
          // If l1 is greater than r2, move search space left
          else if (l1 > r2) {
              high = mid - 1;
          } 
          // If l2 is greater than r1, move search space right
          else {
              low = mid + 1;
          }
      }
      
      return 0.0; // This should never be reached if input constraints are valid
  }
}
