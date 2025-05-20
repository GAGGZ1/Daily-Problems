class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int diff[] = new int[n + 1];
        for (int[] q : queries) {
            int s = q[0];
            int e = q[1];
            diff[s] += 1;
            diff[e + 1] -= 1;

        }
        for (int i = 1; i < n + 1; i++) {
            diff[i] += diff[i - 1];

        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > diff[i]) {
                return false;
            }
        }
        // System.out.println(Arrays.toString(diff));
        return true;
    }
}