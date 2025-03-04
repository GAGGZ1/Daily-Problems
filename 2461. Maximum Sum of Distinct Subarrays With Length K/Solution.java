import java.util.HashSet;

class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
        int l = 0;  // Left pointer for the sliding window
        int r = 0;  // Right pointer for the sliding window
        long maxsum = 0;  // Stores the maximum subarray sum
        long sum = 0;  // Stores the sum of the current window
        int n = arr.length;  // Length of the array
        HashSet<Integer> set = new HashSet<>();  // Set to store unique elements in the window

        while (r < n) {  
            // If the current element is already in the set, shrink the window from the left
            while (set.contains(arr[r])) {
                sum -= arr[l];  // Remove the leftmost element from sum
                set.remove(arr[l]);  // Remove it from the set
                l++;  // Move left pointer forward
            }

            // Add the current element to the window
            sum += arr[r];
            set.add(arr[r]);

            // If the window size becomes exactly 'k'
            if (r - l + 1 == k) {
                maxsum = Math.max(maxsum, sum);  // Update maxsum if the current sum is greater
                
                // Slide the window by removing the leftmost element
                sum -= arr[l];
                set.remove(arr[l]);
                l++;
            }

            r++;  // Expand the window by moving the right pointer
        }
        return maxsum;  // Return the maximum sum found
    }
}
