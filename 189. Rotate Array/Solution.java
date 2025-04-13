class Solution {
  public void rev(int arr[], int l, int e) {
      
      int n = arr.length;
      int r = e - 1;
      while (l < r) {
          int temp = arr[l];
          arr[l] = arr[r];
          arr[r] = temp;
          r--;
          l++;
      }
  }

  public void rotate(int[] nums, int k) {
      int n = nums.length;
      if(k>n)k=k%n;
      rev(nums, 0, n);
      rev(nums, 0, k);
      rev(nums, k, n);

  }
}