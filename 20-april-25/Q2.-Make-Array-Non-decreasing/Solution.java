class Solution {
  public int maximumPossibleSize(int[] nums) {
      int i=0;
      int j=1;
      int n=nums.length;
      if(n<=1)return n;

      while(j<n){
          if(nums[i]>nums[j] ){
              nums[j]=-1;
              j++;
              
          }else{
              i=j;
              j++;
          }
      }
      int count=0;
      for(int k=0;k<n;k++){
          if(nums[k]!=-1){
              count++;
          }
      }
      return count;
  }
}

// Time Complexity: O(n)
// Space Complexity: O(1)