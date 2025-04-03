import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
  public static long binaryExponentiation(long base, int exp, long mod) {
    long result = 1;
    base = base % mod;
    while (exp > 0) {
      if (exp % 2 == 1) {
        result = (result * base) % mod;
      }
      base = (base * base) % mod;
      exp = exp / 2;
    }
    return result;
  }

  public static void main(String[] args) throws java.lang.Exception {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    final long MOD = 998244353;

    while (t-- > 0) {
      int n = sc.nextInt();
      long[] arr = new long[n];

      for (int i = 0; i < n; i++) {
        arr[i] = binaryExponentiation(2, i, MOD);
      }

      long x = 0, y = 0;
      boolean alice = true;

      for (int i = 0; i < n; i++) {
        long canbeScoreAdd = (x + arr[i]);
        long canbeScoreSub = (x - arr[i]);

        if (alice) {
          if (Math.abs(canbeScoreAdd - y) < Math.abs(canbeScoreSub - y)) {
            x = canbeScoreAdd;
          } else {
            y = canbeScoreSub;
          }
        } else {
          if (Math.abs(canbeScoreAdd - y) > Math.abs(canbeScoreSub - y)) {
            x = canbeScoreAdd;
          } else {
            y = canbeScoreSub;
          }
        }
        alice = !alice;
      }

      System.out.println((x - y + MOD) % MOD);
    }
  }
}
