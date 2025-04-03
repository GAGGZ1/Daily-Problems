import java.util.*;

public class Solution {
  public static int calculateMinPatforms(int at[], int dt[], int n) {
    int i = 0;
    int j = 0;
    Arrays.sort(at);
    Arrays.sort(dt);

    int maxplat = 0;
    int currplat = 0;

    while (i < n && j < n) {
      if (at[i] <= dt[j]) {
        currplat++;
        i++;
        maxplat = Math.max(maxplat, currplat);
      } else {
        currplat--;
        j++;
      }
    }
    return (maxplat);

  }
}