class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        Queue<int[]> q = new LinkedList<>();

        q.add(entrance);
        int minCount = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[n][m];
        visited[entrance[0]][entrance[1]] = true;
        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int dis = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int x = 0; x < size; x++) {
                int[] idx = q.poll();
                int i = idx[0];
                int j = idx[1];

                for (int k = 0; k < 4; k++) {
                    int newR = i + dir[k][0];
                    int newC = j + dir[k][1];

                    if (newR < 0 || newR >= n || newC < 0 || newC >= m) {
                        continue;
                    }

                    if (maze[newR][newC] == '.' && !visited[newR][newC]) {
                        if (newR == 0 || newR == n - 1 || newC == 0 || newC == m - 1) {
                            return dis + 1;
                        }
                        visited[newR][newC] = true;
                        q.add(new int[] { newR, newC });
                    }
                }
            }
            dis++;

        }
        return -1;

    }
}