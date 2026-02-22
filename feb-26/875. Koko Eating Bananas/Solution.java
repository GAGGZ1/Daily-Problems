class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        for(int p:piles){
          high=  Math.max(high,p);
        }

        while(low<high){
            int mid=low+(high-low)/2;
            int hr=0;
            for(int p:piles ){
                hr+=(p+mid-1)/mid;
            }

            if(hr>h){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }
}