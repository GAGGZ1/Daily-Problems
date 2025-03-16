class Solution {
    public int maxScore(int[] arr, int k) {
        int leftsum = 0;
        int n = arr.length;
        
        // Calculate the initial sum by picking the first k elements from the left
        for (int i = 0; i <= k - 1; i++) {
            leftsum += arr[i];
        }
        
        int maxsum = leftsum; // Store the maximum sum found so far
        int idx = n - 1; // Pointer to the last element of the array
        int rightsum = 0; // Sum of elements taken from the right side
        
        // Iterate backward from the last selected left element
        for (int i = k - 1; i >= 0; i--) {
            leftsum -= arr[i]; // Remove the leftmost selected element
            rightsum += arr[idx]; // Add an element from the right side
            idx--; // Move the right pointer left
            maxsum = Math.max(leftsum + rightsum, maxsum); // Update the maximum sum if needed
        }
        
        return maxsum; // Return the maximum possible sum
    }
}
