class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        // 1  2  3  4
        // 5  6  7  8
        // 9 10 11 12

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < grid[i].length; j += 2) {
                    ans.add(grid[i][j]);
                }
            } else {
                int k;
                if (grid[i].length % 2 == 0) {
                    k = grid[i].length - 1;
                } else {
                    k = grid[i].length - 2;
                }
                for (int j = k; j >= 0; j -= 2) {
                    ans.add(grid[i][j]);
                }
            }
        }
        return ans;

    }
}