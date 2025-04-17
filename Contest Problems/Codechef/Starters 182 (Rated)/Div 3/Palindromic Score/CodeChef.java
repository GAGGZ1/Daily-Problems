import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
  public static void main(String[] args) throws java.lang.Exception {
    // your code goes here
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      int z = sc.nextInt();

      // if (x >= y && x >= z) {
      // max = x;
      // if (y % 2 != 0) oddCount++;
      // if (z % 2 != 0) oddCount++;

      // if (oddCount <= 1) {
      // System.out.println(y+z);
      // } else {
      // System.out.println(y+z-1);
      // }

      // } else if (y >= x && y >= z) {
      // max = y;
      // } else {
      // max = z;
      // }

      int max;
      int oddCount = 0;

      if (x >= y && x >= z) {
        max = x;

        if (y % 2 != 0)
          oddCount++;
        if (z % 2 != 0)
          oddCount++;

        if (oddCount <= 1) {

          System.out.println((y + z));
        } else {

          System.out.println((y + z - 1));
        }

      } else if (y >= x && y >= z) {
        max = y;

        if (x % 2 != 0)
          oddCount++;
        if (z % 2 != 0)
          oddCount++;

        if (oddCount <= 1) {

          System.out.println((x + z));
        } else {

          System.out.println((x + z - 1));
        }

      } else {
        max = z;

        if (x % 2 != 0)
          oddCount++;
        if (y % 2 != 0)
          oddCount++;

        if (oddCount <= 1) {

          System.out.println((x + y));
        } else {

          System.out.println((x + y - 1));
        }
      }

    }

  }
}
