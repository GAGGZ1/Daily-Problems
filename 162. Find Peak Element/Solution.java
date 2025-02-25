class Solution {
  public int findPeakElement(int[] arr) {
      int n = arr.length;
      int l = 0;
      int e = n - 1;
      while (l < e) {
          int m = l + (e - l) / 2;
          if (arr[m] < arr[m + 1]) {
              l = m + 1;
          } else {
              e = m;
          }
      }
      return l;
  }
}