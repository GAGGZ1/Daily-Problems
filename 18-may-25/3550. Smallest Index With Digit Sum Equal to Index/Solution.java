class Solution {
    public int digi(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
        int min=Integer.MAX_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(digi(nums[i])==i){
                if(min>i){
                    min=i;
                }
            }
        }
        if(min==Integer.MAX_VALUE)return -1;
        return min;
    }
}