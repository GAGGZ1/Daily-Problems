class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int i = 0; i < n; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            int sum = 0;
            int count = 1;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                if (sum > mid) {
                    sum = nums[i];
                    count++;
                }
            }
            if (count > k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}