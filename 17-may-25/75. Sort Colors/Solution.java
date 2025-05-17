class Solution {
    public void sortColors(int[] nums) {
        int s = 0;
        int m = 0;
        int e = nums.length - 1;

        while (m <= e) {
            if (nums[m] == 1) {
                m++;
            } else if (nums[m] == 2) {
                int temp = nums[m];
                nums[m] = nums[e];
                nums[e] = temp;

                e--;
            } else {
                int temp = nums[s];
                nums[s] = nums[m];
                nums[m] = temp;
                s++;
                m++;
            }
        }
    }
}