import java.util.*;
class Solution {
  public int[] getAverages(int[] nums, int k) {
      int l = 0;
      int r = 0;
      
      int n = nums.length;
      
      int res[] = new int[n];
      if(n<k){
          Arrays.fill(res,-1);
          return res;
      }
      int sum = 0;
      for (int i = 0; i < k; i++) {
          res[i] = -1;
          sum += nums[i];
      }
      r = k;

      while (r < n) {
          int idx = r + k;
          if (idx < n) {
              for (int i = r; i <= idx; i++) {
                  sum += nums[i];
              }
              res[r] = sum / (2 * k + 1);
          }
          r++;
          sum -= nums[l];
          l++;
      }

      while (r < n) {
          res[r] = -1;
          r++;
      }
      return res;

  }
  public static void main(String[] args) {
    Solution s = new Solution();
    int[]nums = {7,4,3,9,1,8,5,2,6};
    int k = 3;
    int []arr=s.getAverages(nums, k);
    for(int i=0;i<arr.length;i++){
      System.out.print(arr[i]+" ");
    }
  }
}