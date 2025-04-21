class Solution {
  int maxSubarraySum(int[] arr) {
      // Your code here
    
  int n=arr.length;
  int max=Integer.MIN_VALUE;
  
  int curr=0;
  for(int i=0;i<n;i++){
      curr=Math.max(arr[i],arr[i]+curr);
      max=Math.max(curr,max);
  }
  return max;
  }
}
