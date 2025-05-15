import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {

  static int calculateDifference(int aa, int bb) {
    int dd = aa - bb;
    return dd;
  }

  static int calculateLinearValue(int mm, int nn, int bb) {
    int ll = mm - nn * bb;
    return ll;
  }

  static String processZeroDifferenceCase(int nn, int aa, int mm) {
    int cc = nn * aa;
    if (cc == mm) {
      return "Yes";
    } else {
      return "No";
    }
  }

  static String processNonZeroDifferenceCase(int nn, int ll, int dd) {

    int ff = ll % dd;
    int gg = ll / dd;
    if (ff != 0) {
      return "No";
    } else {
      if (gg >= 0 && gg <= nn) {
        return "Yes";
      } else {
        return "No";
      }
    }
  }

  public static void main(String[] args) throws java.lang.Exception {
    Scanner sc = new Scanner(System.in);
    int tt = sc.nextInt();
    while (tt-- > 0) {
      int nn = sc.nextInt();
      int mm = sc.nextInt();
      int aa = sc.nextInt();
      int bb = sc.nextInt();

      int dd = calculateDifference(aa, bb);
      int ll = calculateLinearValue(mm, nn, bb);

      String result;
      if (dd == 0) {
        result = processZeroDifferenceCase(nn, aa, mm);
      } else {
        result = processNonZeroDifferenceCase(nn, ll, dd);
      }
      System.out.println(result);
    }
    sc.close();
  }
}