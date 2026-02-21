
public class Solution {
  public static String reverse(String s){
    if(s.length()<=1)return s;

    return s.substring(1)+s.charAt(0);
  }
  public static void main(String[] args){
    System.out.println(reverse("hello"));
  }
}
