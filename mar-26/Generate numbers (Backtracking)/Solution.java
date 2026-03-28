
import java.util.*;
public class Solution {
  public static void main(String[] args){
  int digit[]={1,2,3,4,5};
  int n=100;
  ArrayList<Integer>ls=new ArrayList<>();
  generate(digit,n,"",ls);
  for(int i=0;i<ls.size();i++){
    System.out.print(ls.get(i)+" ");
  }}
  public static void generate(int[]digits,int n, String curr,ArrayList<Integer>res){
    if(!curr.isEmpty()){
      int num=Integer.parseInt(curr);
      if(num>n){
       return;
      }
       res.add(num);
    }

    for(int d:digits){
      generate(digits,n,curr+d,res);
    }
  }
}
