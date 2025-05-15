import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
  private static final int MOD = 998244353;

  private static long modFactorial(long n) {
    long result = 1;
    for (long i = 2; i <= n; i++) {
      result = (result * i) % MOD;
    }
    return result;
  }

  public static long countUniqueArrays(long[] ranges) {
    Arrays.sort(ranges);
    long totalWays = 1;

    for (int i = 0; i < ranges.length; i++) {
      long ways = ranges[i] - i;
      if (ways <= 0) {
        return 0;
      }
      totalWays = (totalWays * ways) % MOD;
    }
    return totalWays;
  }

  public static void main(String[] args) throws java.lang.Exception {

    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int arr[] = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int b[] = arr.clone();
      Arrays.sort(b);
      int ans[] = new int[n];
      int max = b[b.length - 1];
      long[] ans2 = new long[n];
      for (int i = 0; i < n; i++) {
        if (arr[i] < max) {
          ans2[i] = arr[i];
        } else {
          ans2[i] = max;
        }
      }

      long res = 1;
      for (int i = 0; i < n; i++) {
        res = (res * ans2[i]) % 998244353;
      }
      int min = Integer.MAX_VALUE;
      for (int i = 0; i < n; i++) {
        if (ans[i] < min) {
          min = ans[i];
        }
      }
      res = 1;
      res = (res * min) % 998244353;

      System.out.println(countUniqueArrays(ans2));

    }
  }
}