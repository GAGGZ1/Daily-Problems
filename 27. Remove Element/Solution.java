class Solution {
  public int removeElement(int[] nums, int val) {
      int idx=0;
      int i=0;
      int n=nums.length;
      while(idx<n){
          if(nums[idx]!=val){
              nums[i++]=nums[idx++];
          }
          else{
              idx++;
          }
      }
      return i;
  }
}