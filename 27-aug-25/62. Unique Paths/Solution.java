class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return solve(m, n, 0, 0, dp);
    }

    public int solve(int m, int n, int i, int j, int dp[][]) {
        if (i == m - 1 && j == n - 1)
            return 1;
        if (i >= m || j >= n)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int left = solve(m, n, i + 1, j, dp);
        int right = solve(m, n, i, j + 1, dp);
        return dp[i][j] = right + left;
    }
}

// Start from (0,0) → move right or down.
// If reach (m-1, n-1) → 1 path found.
// If out of bounds → 0 paths.
// Use DP memoization to store results for (i,j) to avoid recomputation.
// Return sum of paths from right + down.