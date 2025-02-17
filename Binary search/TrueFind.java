import java.util.*;
public class TrueFind{
  public static void main(String[] args){
    boolean[]arr={ false, true, true, true};
    int i=findindex(arr,true);
    System.out.println(i);
  }
  public static int findindex(boolean[]arr,boolean target){
    int s=0;
    int e=arr.length-1;
    int idx=-1;
    while(s<=e){
      int m=s+(e-s)/2;
      if(arr[m]==target){
        idx=m;
        e=m-1;

      }
      else if(arr[m]==false){
        s=m+1;
      }
    }
    return idx;
  }
}