class Solution {
  public List<Integer> goodIndices(int[] nums, int k) {
      int n=nums.length;
      int left[]=new int[n];
      left[0]=1;
      for(int i=1;i<n;i++){
          if(nums[i-1]>=nums[i]){
              left[i]=left[i-1]+1;
          }
          else{
              left[i]=1;
          }
      }
      int right[]=new int[n];
      right[n-1]=1;
      for(int i=n-2;i>=0;i--){
          if(nums[i]<=nums[i+1]){
              right[i]=right[i+1]+1;
          }
          else{
              right[i]=1;
          }
      }
      // System.out.println(Arrays.toString(left));
      // System.out.println(Arrays.toString(right));
      ArrayList<Integer>ls=new ArrayList<>();
      for(int i=k;i<n-k;i++){
          if(left[i-1]>=k && right[i+1]>=k){
              ls.add(i);
          }
      }
      return ls;

  }
}