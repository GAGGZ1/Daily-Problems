import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        long k = sc.nextLong();

        long[] a = new long[n];
        long[] b = new long[m];
        long[] pa = new long[n + 1];
        long[] pb = new long[m + 1];
        pa[0] = 0;
        pb[0] = 0;

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
            pa[i + 1] = pa[i] + a[i];
        }

        for (int i = 0; i < m; i++) {
            b[i] = sc.nextLong();
            pb[i + 1] = pb[i] + b[i];
        }

        long ans = 0;

        for (int i = 0; i <= n; i++) {
            if (pa[i] > k) {
                break;
            }

            int left = 0, right = m;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (pa[i] + pb[mid] <= k) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            ans = Math.max(ans, i + right);
        }

        System.out.println(ans);

    }
}
