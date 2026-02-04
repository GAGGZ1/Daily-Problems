class Solution {
    public int maxProfit(int[] p) {
        int min = p[0];
        int diff = 0;
        for (int i = 1; i < p.length; i++) {
            if (min > p[i]) {
                min = p[i];
            } else {
                diff = Math.max(diff, p[i] - min);
            }
        }
        return diff;
    }
}