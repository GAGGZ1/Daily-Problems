import java.util.*;

class Codechef {

  public static void main(String[] args) throws java.lang.Exception {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();
      System.out.println(getMaxAliceChocolate(n, m, k));
    }
  }

  public static int getMaxAliceChocolate(int n, int m, int k) {
    int total = n * m;
    int maxAlice = 0;

    maxAlice = Math.max(maxAlice, tryHorizontalCuts(n, m, k));

    maxAlice = Math.max(maxAlice, tryVerticalCuts(n, m, k));

    if (k == 0)
      return total;

    return maxAlice;
  }

  public static int tryHorizontalCuts(int n, int m, int k) {
    int maxKeep = 0;
    for (int i = 1; i < n; i++) {
      int part1 = i * m;
      int part2 = (n - i) * m;
      if (part1 >= k)
        maxKeep = Math.max(maxKeep, part2);
      if (part2 >= k)
        maxKeep = Math.max(maxKeep, part1);
    }
    return maxKeep;
  }

  public static int tryVerticalCuts(int n, int m, int k) {
    int maxKeep = 0;
    for (int j = 1; j < m; j++) {
      int part1 = j * n;
      int part2 = (m - j) * n;
      if (part1 >= k)
        maxKeep = Math.max(maxKeep, part2);
      if (part2 >= k)
        maxKeep = Math.max(maxKeep, part1);
    }
    return maxKeep;
  }
}
