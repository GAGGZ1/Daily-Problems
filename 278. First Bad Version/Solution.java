/* The isBadVersion API is defined in the parent class VersionControl.
   boolean isBadVersion(int version); */

   public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int s = 1; // Start of the search range
        int e = n; // End of the search range
        int ans = 0; // Variable to store the first bad version
        
        // Perform binary search to find the first bad version
        while (s <= e) {
            int m = s + (e - s) / 2; // Calculate the middle version to avoid overflow
            
            if (isBadVersion(m)) { // If the current version is bad
                ans = m; // Store the bad version
                e = m - 1; // Continue searching in the left half
            } else {
                s = m + 1; // Move to the right half if the current version is good
            }
        }
        
        return ans; // Return the first bad version found
    }
}
