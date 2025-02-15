
import java.util.*;

public class Solution{
  public static void main(String[] args){
    int[] arr = {2, 4, 1, 3, 5};
    System.out.println(countInversions(arr));
  }
  public static int countInversions(int [] arr){
    return merge_sort(arr,0,arr.length-1);
  }
  public static int merge_sort(int []arr,int s,int e){

    int count=0;
    if(s<e){
      int m=s+(e-s)/2;
      count+=merge_sort(arr,s,m);
      count+=merge_sort(arr,m+1,e);
      count+=merge(arr,s,m,e);
    
   
  }
  return count;

}
 public static int merge(int arr[],int s,int m,int e){
  ArrayList<Integer>temp=new ArrayList<>();
  int i=s;
  int j=m+1;
  int count=0;
  while(i<=m && j<=e){
    if(arr[i]<arr[j]){
      temp.add(arr[i]);
      i++;
    }
    else{
      temp.add(arr[j]);
      j++;
      count+=m-i+1;

    }
  }
  while(i<=m){
    temp.add(arr[i]);
    i++;
  }
  while(j<=e){
    temp.add(arr[j]);
    j++;
  }
  for(int idx=0;idx<temp.size();idx++){
    arr[idx+s]=temp.get(idx);
  }
  return count;

 }
}
