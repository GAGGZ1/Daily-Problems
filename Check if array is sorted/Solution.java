class Solution {
  public boolean arraySortedOrNot(int[] arr) {
      // code here
      return check(arr,1);
      
  }
  public boolean check(int[]arr,int i){
      if(i==arr.length)return true;
      if(arr[i-1]>arr[i])return false;
      return check(arr,i+1);
  }
}