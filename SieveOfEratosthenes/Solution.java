import java.util.*;

public class Solution {
  public static void main(String[] args) {
    int n=40;
    boolean prime[]=new boolean[n+1];
    Arrays.fill(prime,true);

    for(int i=2;i*i<=n;i++){
      if(prime[i]==true){
        for(int j=i+i;j<=n;j+=i){
          prime[j]=false;
        }
      }
    }
    for(int i=2;i<=n;i++){
      if(prime[i]==true){
        System.out.print(i+" ");
      }
    }
  }
}
