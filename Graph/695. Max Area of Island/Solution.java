class Solution {
    int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public int maxAreaOfIsland(int[][] graph) {

        int max = 0;
        int n = graph.length;
        int m = graph[0].length;
        boolean[][] visi = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && visi[i][j] != true) {
                    max = Math.max(max, findRegions(graph, i, j, n, m, visi));
                }
            }
        }
        return max;

    }

    public int findRegions(int[][] graph, int i, int j, int n, int m, boolean visi[][]) {
        if (i >= n || j >= m || i < 0 || j < 0 || graph[i][j] == 0 || visi[i][j] == true) {
            return 0;
        }
        visi[i][j] = true;
        int count = 1;

        for (int k = 0; k < 4; k++) {
            int ni = i + dir[k][0];
            int nj = j + dir[k][1];

            count += findRegions(graph, ni, nj, n, m, visi);
        }
        return count;

    }
}