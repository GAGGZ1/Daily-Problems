class Solution {
  public int[] rearrangeArray(int[] nums) {
      int arr[] = new int[nums.length];
      int pos = 0;
      int pn = 1;
      for (int ele : nums) {
          if (ele > 0) {
              arr[pos] = ele;
              pos += 2;
          } else {
              arr[pn] = ele;
              pn += 2;
          }
      }
      return arr;
  }
}