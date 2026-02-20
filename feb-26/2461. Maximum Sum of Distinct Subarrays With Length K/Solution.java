class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        long maxsum = 0;
        long currsum = 0;

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (set.contains(nums[right])) {
                currsum -= nums[left];
                set.remove(nums[left]);
                left++;

            }
            currsum += nums[right];
            set.add(nums[right]);
            if (right - left + 1 == k) {
                maxsum = Math.max(currsum, maxsum);
                currsum -= nums[left];
                set.remove(nums[left]);
                left++;
            }

        }
        return maxsum;

    }
}