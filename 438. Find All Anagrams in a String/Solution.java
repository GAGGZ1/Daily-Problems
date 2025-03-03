import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // HashMap to store character frequencies of string p
        HashMap<Character, Integer> pmap = new HashMap<>();
        // HashMap to store character frequencies of the current window in s
        HashMap<Character, Integer> smap = new HashMap<>();
        // List to store starting indices of anagrams found
        List<Integer> ans = new ArrayList<>();

        int m = p.length(); // Length of pattern p
        int n = s.length(); // Length of string s

        // Build frequency map for string p
        for (int i = 0; i < m; i++) {
            pmap.put(p.charAt(i), pmap.getOrDefault(p.charAt(i), 0) + 1);
        }

        int l = 0; // Left pointer of the sliding window
        int r = 0; // Right pointer of the sliding window

        // Iterate over string s using a sliding window
        while (r < n) {
            // Expand the window by adding the current character to smap
            smap.put(s.charAt(r), smap.getOrDefault(s.charAt(r), 0) + 1);

            // If the window size exceeds the size of p, shrink it from the left
            if (r - l + 1 > m) {
                // Reduce the frequency of the leftmost character in smap
                smap.put(s.charAt(l), smap.get(s.charAt(l)) - 1);

                // If the frequency becomes 0, remove the character from smap
                if (smap.get(s.charAt(l)) == 0) {
                    smap.remove(s.charAt(l));
                }

                // Move the left pointer forward to maintain window size
                l++;
            }

            // If the frequency map of the current window matches p's frequency map, store
            // the index
            if (smap.equals(pmap)) {
                ans.add(l);
            }

            // Move the right pointer forward
            r++;
        }

        // Return the list of starting indices of anagrams found
        return ans;
    }
}
