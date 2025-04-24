class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        int ans = solve(s, 0, n - 1, n, dp);
        return ans;
    }

    public int solve(String s, int i, int j, int n, int[][] dp) {

        if (i > j)
            return 0;
        if (i == j)
            return 1;
        if (dp[i][j] != -1)
            return dp[i][j];
        int ans = 0;

        if (s.charAt(i) == s.charAt(j)) {
            ans = 2 + solve(s, i + 1, j - 1, n, dp);
        } else {
            ans = Math.max(solve(s, i + 1, j, n, dp), solve(s, i, j - 1, n, dp));
        }

        dp[i][j] = ans;
        return ans;

    }
}

// Time Complexity: O(n^2)
// Space Complexity: O(n^2)