class Solution {
    public int minMoves(String[] mat) {
        int r = mat.length;
        int c = mat[0].length();
        if (mat[0].charAt(0) == '#')
            return -1;

        int dists[][] = new int[r][c];
        for (int[] d : dists) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        int dirs[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        HashMap<Character, List<int[]>> portals = new HashMap<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                char ch = mat[i].charAt(j);
                if (Character.isLetter(ch)) {
                    portals.putIfAbsent(ch, new ArrayList<>());
                    portals.get(ch).add(new int[] { i, j });
                }
            }
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.offerFirst(new int[] { 0, 0 });
        dists[0][0] = 0;
        Set<Character> set = new HashSet<>();
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];

            if (x == r - 1 && y == c - 1) {
                return dists[x][y];
            }
            char ch = mat[x].charAt(y);

            //teleport letter hai?
            if (Character.isLetter(ch) && !set.contains(ch)) {
                set.add(ch);
                for (int[] pp : portals.get(ch)) {
                    int px = pp[0];
                    int py = pp[1];
                    if ((px != x || py != y) && dists[px][py] > dists[x][y]) {
                        dists[px][py] = dists[x][y];
                        q.offerFirst(new int[] { px, py });
                    }
                }
            }

            //ya nhi hai
            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx >= 0 && ny >= 0 && nx < r &&
                        ny < c && mat[nx].charAt(ny) != '#') {
                    if (dists[nx][ny] > dists[x][y] + 1) {
                        dists[nx][ny] = dists[x][y] + 1;
                        q.offer(new int[] { nx, ny });
                    }
                }
            }

        }
        return -1;

    }
}