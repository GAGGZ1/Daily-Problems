class Solution {
    static int count;

    public int reversePairs(int[] nums) {
        count = 0;
        merge_sort(nums, 0, nums.length - 1);
        return count;
    }

    public void merge_sort(int arr[], int s, int e) {
        if (s < e) {
            int m = s + (e - s) / 2;
            merge_sort(arr, s, m);
            merge_sort(arr, m + 1, e);
            merge(arr, s, m, e);
        }
    }

    public void merge(int arr[], int s, int m, int e) {

        // Count reverse pairs
        int i = s;
        int j = m + 1;
        while (i <= m && j <= e) {
            if ((long) arr[i] > 2L * arr[j]) {
                count += (m - i + 1);
                j++;
            } else {
                i++;
            }
        }

        // Merge the two sorted halves
        ArrayList<Integer> temp = new ArrayList<>();
        i = s;
        j = m + 1;
        while (i <= m && j <= e) {
            if (arr[i] <= arr[j]) {
                temp.add(arr[i++]);
            } else {
                temp.add(arr[j++]);

            }
        }
        while (i <= m)
            temp.add(arr[i++]);
        while (j <= e)
            temp.add(arr[j++]);
        for (int k = 0; k < temp.size(); k++) {
            arr[s + k] = temp.get(k);
        }
    }
}