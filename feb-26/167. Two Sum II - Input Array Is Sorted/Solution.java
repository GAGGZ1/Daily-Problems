class Solution {
    public int[] twoSum(int[] num, int tar) {
        int i = 0;
        int n = num.length;
        int j = n - 1;
        while (i < j) {
            if (num[i] + num[j] == tar) {
                return new int[] { i + 1, j + 1 };
            } else if (num[i] + num[j] < tar) {
                i++;
            } else {
                j--;
            }
        }
        return new int[] { -1, -1 };
    }
}