class Solution {
  public int findMin(int[] arr) {
      int n = arr.length;
      int s = 0, e = n - 1;
      if (arr[s] <= arr[e])
          return arr[0];
      while (s < e) {
          int m = s + (e - s) / 2;
          if (arr[m] >= arr[0]) {
              s = m + 1;
          } else {
              e = m;
          }
      }
      return arr[s];
  }
}