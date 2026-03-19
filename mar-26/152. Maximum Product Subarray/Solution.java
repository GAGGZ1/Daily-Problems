class Solution {
    public int maxProduct(int[] nums) {
        int maxSum=nums[0];
        int minSum=nums[0];
        int result=nums[0];

        for(int i=1;i<nums.length;i++){

            //swap if number is negative as negative number can flip the product
            if(nums[i]<0){
                int tempSum=maxSum;
                maxSum=minSum;
                minSum=tempSum;
            }
            maxSum=Math.max(nums[i],maxSum*nums[i]);
            minSum=Math.min(nums[i],minSum*nums[i]);

            result=Math.max(result,maxSum);
        }

        return result;
    }
}