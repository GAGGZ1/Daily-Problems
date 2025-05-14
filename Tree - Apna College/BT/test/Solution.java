import java.lang.reflect.Array;
import java.util.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int k=sc.nextInt();
    sc.nextLine();
    String []input=sc.nextLine().split(" ");
    int []val=new int[input.length];
    for(int i=0;i<input.length;i++){
      val[i]=Integer.parseInt(input[i]);
    }
    System.out.println(Arrays.toString(val));

  }
}
