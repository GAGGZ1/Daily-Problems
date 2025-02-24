import java.util.*;
class Solution {
  static int numberOfWays(int n) {
      int dp[]=new int[n+1];
      Arrays.fill(dp,-1);
     return ways(n,dp);
  }
   static int ways(int n,int[]dp){
        // code here
      if(n==0 || n==1){
          return 1;
      }
      if(dp[n]!=-1){
          return dp[n];
      }
      int w1=ways(n-1,dp);
      int w2=ways(n-2,dp);
      return dp[n]=w1+w2;
   }
};