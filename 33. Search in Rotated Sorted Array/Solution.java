class Solution {
  public int search(int[] arr, int target) {
      int n = arr.length;
      int s = 0;
      int e = n - 1;
      while (s <= e) {
          int m = s + (e - s) / 2;
          if (arr[m] == target) {
              return m;
          } else if (arr[s] <= arr[m]) {
              if (arr[s] <= target && target < arr[m]) {
                  e = m - 1;
              } else {
                  s = m + 1;
              }
          } else {
              if (arr[m] < target && target <= arr[e]) {
                  s = m + 1;
              } else {
                  e = m - 1;
              }
          }
      }
      return -1;
  }
}