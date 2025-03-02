import java.util.*;  // Importing utility package for ArrayList
import java.io.*; 
import java.util.ArrayList;

class Solution {
    // Function to generate all subsequences of a given string
    public static ArrayList<String> subsequences(String str) {
        ArrayList<String> ans = new ArrayList<>();  // List to store subsequences
        solve(str, new StringBuilder(), ans, 0);  // Helper function to generate subsequences
        return ans;
    }

    // Recursive function to generate subsequences
    public static void solve(String s, StringBuilder sb, ArrayList<String> ans, int i) {
        // Base case: if we have processed all characters
        if (i == s.length()) {
            if (sb.length() > 0) {  // If subsequence is not empty, add it to the list
                ans.add(sb.toString());
            }
            return;
        }

        // Include current character in subsequence
        sb.append(s.charAt(i));
        solve(s, sb, ans, i + 1);
        
        // Backtrack: remove last character and move to the next possibility
        sb.deleteCharAt(sb.length() - 1);   
        solve(s, sb, ans, i + 1); 
    }
}
