
class Solution {
  public static boolean possible(int arr[],int n,int k,int m){
      int s=1;
      int sum=0;
      for(int i=0;i<n;i++){
          if((sum+arr[i])<=m){
              sum+=arr[i];
          }
          else{
              s++;
              sum=arr[i];
          }
          if(s>k){
              return false;
          }
      }return true;
  }
  public static int findPages(int[] arr, int k) {
     int n=arr.length;
     
     if(k>n){
         return -1;
     }
     int s=Integer.MIN_VALUE;
     int e=0;
     int ans=Integer.MAX_VALUE;
     for(int a:arr){
         s=Math.max(a,s);
         e+=a;
     }
     while(s<=e){
         int m=s+(e-s)/2;
         if(possible(arr,n,k,m)){
             ans=m;
             e=m-1;
         }
         else{
             s=m+1;
         }
     }
     return ans;
  }
}