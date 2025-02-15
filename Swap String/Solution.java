import java.util.*;
public class Solution{
  public static void main(String[] args) {
    System.out.println("Enter String: ");
    Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();
    System.out.println("Enter m:");
    int m =sc.nextInt();
    char[][]mat=new char[m][2];
    for(int i=0;i<m;i++){
      System.out.println("Enter "+ (i+1) +  " pairs:");
      mat[i][0]=sc.next().charAt(0);
      mat[i][1]=sc.next().charAt(0);
    }
    String ans=solve(s,m,mat);
    System.out.println("After Swaps:");
    System.out.println(ans);

  }

public static String solve(String s,int m,char[][]mat){
  char[]arr=s.toCharArray();
  for(int i=0;i<m;i++){
    char a=mat[i][0];
    char b=mat[i][1];
    for(int j=0;j<arr.length;j++){
      if(arr[j]==a){
        arr[j]=b;
      }
      else if(arr[j]==b){
        arr[j]=a;
      }
    }
  }
  return new String(arr);
}}