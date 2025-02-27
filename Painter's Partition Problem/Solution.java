import java.util.*;

public class Solution {
public static boolean possible(ArrayList<Integer> boards,int n,int k,int m){
    int s=1;
    int sum=0;
    for(int i=0;i<n;i++){
        if(sum+boards.get(i)<=m){
            sum+=boards.get(i);
        }
        else{
            sum=boards.get(i);
            s++;
        }
        if(s>k){
            return false;
        }
    }
    return true;
}

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
       
       int ans=0;
       int s=Integer.MIN_VALUE;
       int e=0;
       int n=boards.size();
       for(int i=0;i<n;i++){
           e+=boards.get(i);
           s=Math.max(s,boards.get(i));
       }

       while(s<=e){
           int m=s+(e-s)/2;
           if(possible(boards,n,k,m)){
               ans=m;
              e=m-1;
           }
           else{
               s=m+1;
           }
       }
       return ans;
    }
}