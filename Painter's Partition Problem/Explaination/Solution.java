import java.util.*;

public class Solution {
    // Function to check if it's possible to paint all boards with `k` painters in `m` time
    public static boolean possible(ArrayList<Integer> boards, int n, int k, int m) {
        int painters = 1; // Start with the first painter
        int sum = 0; // Current sum of the boards assigned to a painter

        for (int i = 0; i < n; i++) {
            // If adding the current board does not exceed the max time `m`
            if (sum + boards.get(i) <= m) {
                sum += boards.get(i);
            } else {
                // Assign a new painter for the next section
                sum = boards.get(i);
                painters++;
            }
            
            // If more than `k` painters are required, return false
            if (painters > k) {
                return false;
            }
        }
        return true;
    }

    // Function to find the minimum possible max time to paint all boards
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        int n = boards.size(); // Number of boards
        int ans = 0;
        int s = Integer.MIN_VALUE; // Lower bound (minimum possible time)
        int e = 0; // Upper bound (maximum possible time)

        // Calculate the initial search space for binary search
        for (int i = 0; i < n; i++) {
            e += boards.get(i); // Sum of all board lengths (max possible time)
            s = Math.max(s, boards.get(i)); // The minimum time must be at least the largest board
        }

        // Perform binary search on the minimum max time
        while (s <= e) {
            int m = s + (e - s) / 2; // Middle value (possible max time per painter)

            // If it's possible to paint within `m` time, update `ans` and search for a smaller value
            if (possible(boards, n, k, m)) {
                ans = m; // Store the minimum max time found
                e = m - 1; // Try to minimize the max time
            } else {
                s = m + 1; // Increase the lower bound
            }
        }
        return ans; // Return the minimum max time required to paint all boards
    }

    public static void main(String[] args) {
        // Example usage
        ArrayList<Integer> boards = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
        int k = 2; // Number of painters
        System.out.println(findLargestMinDistance(boards, k)); // Expected output: 60
    }
}
