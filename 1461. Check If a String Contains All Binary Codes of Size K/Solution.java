import java.util.HashSet;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        // HashSet to store unique k-length binary substrings
        HashSet<String> set = new HashSet<>();

        // The total number of unique k-length binary sequences (2^k)
        int requiredSize = (int) Math.pow(2, k); // Can be written as (1 << k)
        int n = s.length();

        // If the string length is less than k, it's impossible to have all k-length binary sequences
        if (n < k)
            return false;

        StringBuilder sb = new StringBuilder();

        // Iterate through the string, using a sliding window of size k
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i)); // Add the current character to the window

            // Ensure the sliding window does not exceed size k
            if (sb.length() > k) {
                sb.deleteCharAt(0); // Remove the leftmost character
            }

            // Once we have a k-length substring, add it to the HashSet
            if (sb.length() == k) {
                set.add(sb.toString());

                // If we have found all possible k-length binary sequences, return true early
                if (set.size() == requiredSize)
                    return true;
            }
        }

        // If we finish iterating and haven't found all possible sequences, return false
        return set.size() == requiredSize;
    }
}
