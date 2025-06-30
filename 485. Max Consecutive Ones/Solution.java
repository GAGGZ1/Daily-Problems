class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int maxCount=0;
        for(int n:nums){
            if(n==1){
                count++;
                
            }else{
                maxCount=Math.max(count,maxCount);
                count=0;
            }
        }
        return Math.max(count, maxCount);
    }
}