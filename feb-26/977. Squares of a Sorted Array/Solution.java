class Solution {
    public int[] sortedSquares(int[] nums) {
       int i=0;
       int n=nums.length;
       int []res=new int[n];
       int j=n-1;
       int k=n-1;
       while(i<=j){
        int ls=nums[i]*nums[i];
        int rs=nums[j]*nums[j];
        if(ls<rs){
            res[k]=rs;
            j--;
            k--;
        }else{
            res[k]=ls;
            i++;
            k--;
        }
       }
       return res;
    }
}