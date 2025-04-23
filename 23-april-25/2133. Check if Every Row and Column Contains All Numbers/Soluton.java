class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            boolean[] vis = new boolean[n];
            Arrays.fill(vis, false);
            for (int j = 0; j < n; j++) {
                int num = matrix[i][j];
                if (num < 1 || num > n) {
                    return false;
                }
                vis[num - 1] = true;
            }
            for (int j = 0; j < n; j++) {
                if (!vis[j]) {
                    return false;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            boolean[] vis = new boolean[n];
            Arrays.fill(vis, false);
            for (int i = 0; i < n; i++) {
                int num = matrix[i][j];
                if (num < 1 || num > n) {
                    return false;
                }
                vis[num - 1] = true;
            }
            for (int i = 0; i < n; i++) {
                if (!vis[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}

// Time Complexity (TC): O(n^2)
// Space Complexity (SC): O(n)