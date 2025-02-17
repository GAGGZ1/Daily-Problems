import java.util.*;
public class BinarySearch {
  //array Must be sorted
  public static void main(String[] args) {
    int arr[]={2,7,12,6,23};
    int target=12;
    Arrays.sort(arr);
    int index=binarySearch(arr,target);
    if(index==-1){
      System.out.println("Element not found");}
    else{
      System.out.println("Element found at index "+index);

    }}
    public static int  binarySearch(int[]arr,int target){
      int s=0;
      int e=arr.length-1;
      while(s<=e){
        int m=s+(e-s)/2;
        if(arr[m]==target){
          return m;
      }
      else if(arr[m]<target){
        s=m+1;
      }
      else{
        e=m-1;
      }

      
}return -1;}}
