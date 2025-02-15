import java.util.*;
public class Solution {
  public static void main(String[] args) {
    int arr[] = {12, 6, 13, 5, 11, 7};
    int n=arr.length;
    merge_sort(arr,0,n-1);
   for (int i = 0; i < n; i++) {
        System.out.println(arr[i]);
   }
  }
  public static void merge_sort(int[] arr,int s,int e){
    if(s<e){
      int m=s+(e-s)/2;
      merge_sort(arr,s,m);
      merge_sort(arr,m+1,e);
      merge(arr,s,m,e);
    }

  }
  public static void merge(int[] arr,int s,int m, int e){
    ArrayList<Integer>a=new ArrayList<>();
    int i=s;
    int j=m+1;
    while(i<=m && j<=e){
      if(arr[i]<=arr[j]){
        a.add(arr[i]);
        i++;
      }
      else{
        a.add(arr[j]);
        j++;
      }
    }
    while(i<=m){
      a.add(arr[i]);
      i++;
    }
    while(j<=e){
      a.add(arr[j]);
      j++;
    }
    for(int idx=0;idx<a.size();idx++){
      arr[idx+s]=a.get(idx);
}
  }}