class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return solve(k, n, dp);
    }

    public int solve(int k, int n, int[][] dp) {
        if (n == 0 || n == 1)
            return n;
        if (k == 1)
            return n;

        if (dp[k][n] != -1)
            return dp[k][n];

        int low = 1, high = n;
        int min = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;

            int breaks = solve(k - 1, mid - 1, dp);
            int survives = solve(k, n - mid, dp);
            int worst = 1 + Math.max(breaks, survives);

            min = Math.min(min, worst);

            //neeche jaoo agar jayda egg break h o rhe hai
            if (breaks > survives) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        dp[k][n] = min;
        return min;
    }
}
