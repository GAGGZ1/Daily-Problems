import java.util.*;
public class Solution {
  static class Pair implements Comparable<Pair>{
    int val1;
    int val2;

    public Pair(int val1,int val2){
      this.val1=val1;
      this.val2=val2;
    }

    @Override
    public int compareTo(Pair p){
      return p.val1-this.val1;
    }


  }
  public static void main(String[] args) {
    int[] wt = {3, 1, 2};
    int[] rain = {3, 10, 20};
    int n=wt.length;
    Pair []arr=new Pair[n];
    for(int i=0;i<n;i++){
      arr[i]=new Pair(wt[i],rain[i]);
    }
    Arrays.sort(arr);
    System.out.println("Sorted by weight:");
        for (Pair p : arr) {
            System.out.println("Weight: " + p.val1 + ", Rain: " + p.val2);
        }
  }
}
