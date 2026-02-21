class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        return res(arr,sum,0);
       
    }
    static Boolean res(int arr[],int target,int index){
        if(target==0)return true;
        if(index>=arr.length || target<0)return false;
        return res(arr,target-arr[index],index+1) || res(arr,target,index+1);
    }
}