import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        // Max Heap (PriorityQueue with reverse order) to store the smallest k elements
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = mat.length; // Size of the square matrix

        // Traverse the entire matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pq.add(mat[i][j]); // Add current element to the heap

                // If the heap size exceeds k, remove the largest element (to keep only k
                // smallest)
                if (pq.size() > k) {
                    pq.poll(); // Remove the largest element (root of max heap)
                }
            }
        }

        // The root of the heap now contains the k-th smallest element
        return pq.peek();
    }
}
