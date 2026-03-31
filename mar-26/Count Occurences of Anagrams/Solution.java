// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        int k = pat.length();
        int n = txt.length();

        if (k > n) return 0;

        int[] freq = new int[26];

        // Step 1: frequency of pattern
        for (char c : pat.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0, right = 0;
        int count = k;
        int result = 0;

        while (right < n) {
            // include right character
            char r = txt.charAt(right);
            if (freq[r - 'a'] > 0) {
                count--;
            }
            freq[r - 'a']--;
            right++;

            // if valid anagram
            if (count == 0) {
                result++;
            }

            // maintain window size
            if (right - left == k) {
                char l = txt.charAt(left);
                if (freq[l - 'a'] >= 0) {
                    count++;
                }
                freq[l - 'a']++;
                left++;
            }
        }

        return result;
    }
}