class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int curr=0;
        int min=nums.length+1;
        for(int right=0;right<nums.length;right++){
            curr+=nums[right];
           
            while(curr>=target){
                 min=Math.min(min,right-left+1);
                curr-=nums[left];
                left++;
            }
        }
        return min==nums.length+1?0:min;

    }
}