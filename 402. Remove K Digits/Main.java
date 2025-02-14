import java.util.Scanner;
import java.util.Stack;
public class Main {
  public static void main(String[] args) {
    Scanner  sc=new Scanner(System.in);
    System.out.println("Enter the String: " );
    String s=sc.next();
    System.out.println("Enter the value of k: ");
    int k=sc.nextInt();
    String ans=findMinStr(s,k);
    System.out.println("After removing "+k+" digits, the smallest number is: ");
    System.out.println(ans);

  }
  
  public static String findMinStr(String str,int k){
    int n=str.length();
    Stack<Character>st=new Stack<>();
    for(int i=0;i<n;i++){
      if(!st.isEmpty() && st.peek()>str.charAt(i) && k>0){
        st.pop();
        k--;
      }
      st.push(str.charAt(i));
    }
    if(k>0){
      st.pop();
      k--;
    }
    StringBuilder sb=new StringBuilder();
    while(!st.isEmpty()){
      sb.append(st.pop());

    }
    sb.reverse();

    String ans=sb.toString().replaceAll("^0+","");
    if(ans.length()>0){
      return ans;
    }
    return "0";
  }
}
