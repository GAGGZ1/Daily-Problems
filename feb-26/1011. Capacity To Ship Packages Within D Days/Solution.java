class Solution {
    public int shipWithinDays(int[] w, int days) {
        int high = 0;
        int low=0;
        for (int i = 0; i < w.length; i++) {
            high += w[i];
            low=Math.max(low,w[i]);
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 1;
            int sum2 = 0;
            for (int i = 0; i < w.length; i++) {
                sum2 += w[i];
                if (sum2 > mid) {
                    count++;
                    sum2 = w[i];
                }
            }
            if (count > days) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}