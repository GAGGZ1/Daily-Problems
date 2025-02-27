import java.util.*;
class Solution {
  public static boolean possible(int[]arr,int m,int k){
      int count=1;
      int pos=arr[0];
      int n=arr.length;
      for(int i=1;i<n;i++){
          if(arr[i]-pos>=m){
              count++;
              pos=arr[i];
          }
          if(count>=k)return true;
      }
      return false;
  }
  public static int aggressiveCows(int[] arr, int k) {
     Arrays.sort(arr);
     int n=arr.length;
     int ans=0;
     int s=1;
     int e=arr[n-1]-arr[0];
     while(s<=e){
         int m=s+(e-s)/2;
         if(possible(arr,m,k)){
             ans=m;
             s=m+1;
         }
         else{
             e=m-1;
         }
     }
     return ans;
  }
}