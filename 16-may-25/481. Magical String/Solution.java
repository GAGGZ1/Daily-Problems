class Solution {
    public int magicalString(int n) {
        if (n == 0)
            return 0;
        if (n <= 3)
            return 1;
        int arr[] = new int[n + 1];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 2;

        int writeidx = 3;
        int read = 2;
        int count = 1;
        while (writeidx < n) {
            int nextgrpsize = arr[read];
            int num = arr[writeidx - 1] == 1 ? 2 : 1;

            for (int i = 0; i < nextgrpsize && writeidx < n; i++) {
                arr[writeidx++] = num;
                if (num == 1) {
                    count++;
                }
            }
            read++;
        }
        return count;
    }
}