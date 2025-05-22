class Solution {
    public int minZeroArray(int[] nums, int[][] q) {

        int n = nums.length;
        int diff[] = new int[n + 1];
        int pos = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            while (sum + diff[i] < nums[i]) {

                if(pos>=q.length)return -1;
                int s = q[pos][0];
                int e = q[pos][1];
                int v = q[pos][2];
                pos++;

                if (e < i)
                    continue;
                diff[Math.max(i, s)] += v;
                diff[e + 1] -= v;
            }
            sum += diff[i];

        }
        return pos;
    }
}