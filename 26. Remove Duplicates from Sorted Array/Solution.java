class Solution {
  public int removeDuplicates(int[] nums) {
      int n=nums.length;
      if(n==1)return n;
      int idx=1;
      int currele=nums[0];
      for(int i=1;i<n;i++){
          if(nums[i]!=currele){
              nums[idx]=nums[i];
              currele=nums[i];
              idx++;
          }
      }
      return idx;

  }
}