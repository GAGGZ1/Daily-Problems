class NumArray {
  private int arr[];
  private int[]leftt;
  private int[]rightt;
  public NumArray(int[] nums) {
      arr=nums;
      
      int n=nums.length;
      leftt=new int[n+1];
      rightt=new int[n+1];
      leftt[0]=0;
      for(int i=1;i<=n;i++){
          leftt[i]=leftt[i-1]+nums[i-1];
      }
      // nums=1,2,3,4
      //left=0,1,3,6,10
     
      rightt[n]=0;
      for(int i=n-1;i>=0;i--){
          rightt[i]=rightt[i+1]+nums[i];
      }
      


  }
  
  public int sumRange(int left, int right) {
      return leftt[right+1]-leftt[left];
  }
}

/**
* Your NumArray object will be instantiated and called as such:
* NumArray obj = new NumArray(nums);
* int param_1 = obj.sumRange(left,right);
*/