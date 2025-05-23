class Solution {
    public int twoEggDrop(int n) {
        int[][] dp = new int[n + 1][3];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(n, 2, dp);
    }

    public int solve(int n, int egg, int dp[][]) {
        if (n == 0 || n == 1)
            return n;
        if (egg == 1)
            return n;

        if (dp[n][egg] != -1)
            return dp[n][egg];

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            int b = solve(i - 1, egg - 1, dp);
            int sur = solve(n - i, egg, dp);
            int worst = 1 + Math.max(b, sur);
            min = Math.min(min, worst);
        }
        return dp[n][egg] = min;
    }
}