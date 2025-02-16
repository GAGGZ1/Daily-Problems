import java.util.*;
class Solution {
  public int maximalSquare(char[][] mat) {
      
      int m=mat.length;
      int n=mat[0].length;
      int dp[][]=new int[m+1][n+1];
      for(int[]d:dp){
          Arrays.fill(d,-1);
      }
      int res=0;
      for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
              int ans=solve(mat,m,n,i,j,dp);
              res=Math.max(res,ans);
          }
      }
      
      return res*res;
  }
  public int solve(char[][]mat,int m,int n,int i,int j,int[][]dp){
      if(i>=m || j>=n || mat[i][j]=='0'){
          return 0;}
      
      // if(mat[i][j]=='1'){
      //     return 1;
      // } //wrong
      if(dp[i][j]!=-1){
          return dp[i][j];
      }

      int right=solve(mat,m,n,i,j+1,dp);
      int down=solve(mat,m,n,i+1,j,dp);
      int diagonal=solve(mat,m,n,i+1,j+1,dp);

      return dp[i][j]=1+Math.min((Math.min(right,down)),diagonal);


  }

}