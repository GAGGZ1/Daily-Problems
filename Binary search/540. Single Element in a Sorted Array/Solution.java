class Solution {
  public int singleNonDuplicate(int[] nums) {
      int n = bs(nums);
      return n;
  }

  public int bs(int[] arr) {
      int s = 0;
      int e = arr.length - 1;
      if (e == 0) {
          return arr[0];
      } else if (arr[e] != arr[e - 1]) {
          return arr[e];
      } else if (arr[0] != arr[1]) {
          return arr[0];
      }
      while (s <= e) {
          int m = s + (e - s) / 2;
          if ( m>0 && m<arr.length-1 && arr[m] != arr[m - 1] && arr[m] != arr[m + 1]) {
              return arr[m];
          } else if ((m % 2 == 0 && arr[m] == arr[m +1]) ||( m%2==1 && arr[m]==arr[m-1])) {
              s= m + 1;
          } else {
              e = m -1;
          }
      }
      return -1;
  }
}