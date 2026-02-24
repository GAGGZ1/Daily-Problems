package feb-26.1482. Minimum Number of Days to Make m Bouquets;

public class Solution {
    public int minDays(int[] b, int m, int k) {
        int n=b.length;
        if((long)m*k>n)return -1;

        int low= Integer.MAX_VALUE;
        int high=1;
        for(int i:b){
            low = Math.min(low, i);
            high=Math.max(i,high);
        }
        while(low<high){
            int mid=low+(high-low)/2;
            int count=0;
            int ba=0;
            for(int i=0;i<n;i++){
                if(b[i]<=mid){
                    count++;
                }else{
                    count=0;
                }
                if(count>=k){
                    ba++;
                    count=0;
                }
            }
            if(ba<m){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }
} {
  
}
