class Solution {
  public int maxProfit(int[] p) {
      int profit=0;
      int buy=p[0];
      int n=p.length;
      for(int i=1;i<n;i++){
          if(buy<p[i]){
              profit=Math.max(profit,p[i]-buy);
          }
          else{
              buy=p[i];
          }
      }
      return profit;

  }
}