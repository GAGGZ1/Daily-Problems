import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ArrayList<int[]> result = new ArrayList<>();
        int[] prevInterval = intervals[0];
        result.add(prevInterval);

        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];

            if (prevInterval[1] >= nextInterval[0]) {
                // merge
                prevInterval[1] = Math.max(prevInterval[1], nextInterval[1]);
            } else {
                // no overlap
                result.add(nextInterval);
                prevInterval = nextInterval;
            }
        }

        int[][] answer = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            answer[i][0] = result.get(i)[0];
            answer[i][1] = result.get(i)[1];
        }
        return answer;
    }
}