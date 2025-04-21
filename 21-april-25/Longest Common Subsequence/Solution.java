import java.util.*;
class Solution {
  static int lcs(String s1, String s2) {
      // code here
      int n=s1.length();
      int m=s2.length();
      int dp[][]=new int[n+1][m+1];
      for(int[]d:dp){
          Arrays.fill(d,-1);
      }
      return solve(0,0,s1,s2,dp);
  
  }
  public static int solve(int i,int j,String s1,String s2,int dp[][]){
      if(i==s1.length() || j==s2.length()){
          return 0;
      }
      if(dp[i][j]!=-1){
          return dp[i][j];
      }
      int pick=0;
      int nopick=0;
      int npick=0;
      
      if(s1.charAt(i)==s2.charAt(j)){
          pick=1+solve(i+1,j+1,s1,s2,dp);
      }
       nopick=solve(i,j+1,s1,s2,dp);
       npick=solve(i+1,j,s1,s2,dp);
       return dp[i][j]= Math.max(Math.max(nopick,npick),pick);
  }
}