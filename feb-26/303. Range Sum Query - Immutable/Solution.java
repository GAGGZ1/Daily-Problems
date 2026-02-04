class NumArray {

    int leftsum[];

    public NumArray(int[] nums) {
        int n = nums.length;
        leftsum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            leftsum[i + 1] = nums[i] + leftsum[i];
        }
    }

    public int sumRange(int left, int right) {

        return leftsum[right + 1] - leftsum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

//  prefix[i+1] = prefix[i] + nums[i]