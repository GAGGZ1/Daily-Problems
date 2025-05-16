
class Solution {
    public int maxWeightCell(int[] exits) {
        int n=exits.length;
        int temp[]=new int[n];
        for(int i=0;i<n;i++){
            if(exits[i]!=-1){
                temp[exits[i]]+=i;
            }
        }
        int max=Integer.MIN_VALUE;
        int ans=0;
        for(int i=0;i<n;i++){
            if(max<temp[i]){
                max=temp[i];
                ans=i;
            } else if (temp[i] == max) {
                ans = Math.max(ans, i); 
            }
        }
        return ans;
    }
}