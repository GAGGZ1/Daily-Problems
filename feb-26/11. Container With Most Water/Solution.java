class Solution {
    public int maxArea(int[] nums) {
        int max = 0;
        int i = 0;
        int n = nums.length;
        int j = n - 1;
        while (i < j) {
            if (nums[i] < nums[j]) {
                int a = (j - i) * nums[i];
                max = Math.max(a, max);
                i++;
            } else {
                int b = (j - i) * nums[j];
                max = Math.max(b, max);
                j--;
            }
        }
        return max;
    }
}