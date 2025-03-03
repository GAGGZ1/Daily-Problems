import java.util.*;

public class Solution {
    // Function to count the number of elements less than or equal to mid in a sorted row
    public int counting(ArrayList<Integer> row, int mid) {
        int low = 0, high = row.size();
        
        // Binary search to find the position where elements exceed mid
        while (low < high) {
            int midIndex = low + (high - low) / 2;
            if (row.get(midIndex) <= mid) {
                low = midIndex + 1; // Move right if element is <= mid
            } else {
                high = midIndex; // Move left if element is greater than mid
            }
        }
        return low; // Number of elements <= mid
    }

    // Function to find the median of a row-wise sorted matrix
    public int findMedian(ArrayList<ArrayList<Integer>> a) {
        int n = a.size(); // Number of rows
        int m = a.get(0).size(); // Number of columns
        
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        
        // Finding the minimum and maximum elements in the matrix
        for (int i = 0; i < n; i++) {
            low = Math.min(low, a.get(i).get(0)); // Minimum element in the first column
            high = Math.max(high, a.get(i).get(m - 1)); // Maximum element in the last column
        }
        
        int desiredCount = (n * m) / 2; // The median should be at this position when sorted
        
        // Performing binary search to find the median
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            
            // Counting elements less than or equal to mid in each row
            for (int i = 0; i < n; i++) {
                count += counting(a.get(i), mid);
            }
            
            if (count <= desiredCount) {
                low = mid + 1; // Move right if count is less than or equal to desiredCount
            } else {
                high = mid; // Move left if count is greater
            }
        }
        
        return low; // The median value
    }
}