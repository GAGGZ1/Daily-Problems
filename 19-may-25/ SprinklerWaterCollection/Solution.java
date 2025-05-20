
public class Solution {
  public static void main(String[] args){
    long w=20;
    int []warr={5,2};
    int[]arr={2,1};
    System.out.println("Minimum days : "+ mindays(w,warr,arr));

  }
  public static long mindays(long w,int []warr,int []arr){
    int n=arr.length;
    long left=0;
    long right=(long)1e18;
    long ans=-1;
    while(left<=right){
      long mid=left+(right-left)/2;
      if(canmeet(mid,w,warr,arr)){
        ans=mid;
        right=mid-1;
      }
      elsE{
        left=mid+1;
      }
    }
    return ans;
  }
}
