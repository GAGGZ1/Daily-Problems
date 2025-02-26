
class Solution {
  public int nthRoot(int n, int m) {
      // code here
      int low=1;
      int end=m;
      while(low<=end){
          int mid=low+(end-low)/2;
          if((int)Math.pow(mid,n)==m){
              return mid;
          }
          else if((int)Math.pow(mid,n)>m){
              end=mid-1;
          }
          else{
              low=mid+1;
          }
      }
      return -1;
  }
}