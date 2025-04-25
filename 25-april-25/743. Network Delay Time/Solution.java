class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int distance[] = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        for (int i = 0; i < n; i++) {

            boolean flag = false;
            for (int t[] : times) {
                int u = t[0];
                int v = t[1];
                int d = t[2];
                if (distance[u] != Integer.MAX_VALUE && distance[u] + d < distance[v]) {
                    flag = true;
                    distance[v] = distance[u] + d;
                }
            }
            if (!flag) {
                break;
            }
        }
        int max = 0;
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            } else {
                max = Math.max(distance[i], max);
            }
        }
        return max;
    }
}