import java.util.ArrayList;

public class Solution {
    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        // Define search range for binary search
        int low = Math.max(0, (k - m));  // Minimum elements to take from arr1
        int high = Math.min(k, n);       // Maximum elements to take from arr1

        while (low <= high) {
            int mid = low + (high - low) / 2;  // Mid index for arr1
            int leftelements = k - mid;        // Remaining elements needed from arr2

            // Left boundary elements
            int l1 = Integer.MIN_VALUE;  // Default to minimum if no left element in arr1
            if (mid > 0) {
                l1 = arr1.get(mid - 1);  // Last selected element from arr1
            }

            int l2 = Integer.MIN_VALUE;  // Default to minimum if no left element in arr2
            if (leftelements > 0) {
                l2 = arr2.get(leftelements - 1);  // Last selected element from arr2
            }

            // Right boundary elements
            int r1 = Integer.MAX_VALUE;  // Default to maximum if no right element in arr1
            if (mid < n) {
                r1 = arr1.get(mid);  // First unselected element from arr1
            }

            int r2 = Integer.MAX_VALUE;  // Default to maximum if no right element in arr2
            if (leftelements < m) {
                r2 = arr2.get(leftelements);  // First unselected element from arr2
            }

            // Check if partition is correct
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);  // Found k-th smallest element
            }
            else if (l1 > r2) {
                high = mid - 1;  // Move search space left
            }
            else {
                low = mid + 1;  // Move search space right
            }
        }
        return 0;  // This should never be reached if input constraints are valid
    }
}
