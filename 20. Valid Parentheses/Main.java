import java.util.Scanner;
import java.util.Stack;
class Solution {
  public static boolean isValid(String s) {
      Stack<Character> st = new Stack<>();
      int n = s.length();
      for (int i = 0; i < n; i++) {
          char ch = s.charAt(i);
          if (ch == ')') {
              if (st.isEmpty() || st.peek() != '(') {

                  return false;
              } else {
                  st.pop();

              }

          }

          else if (ch == '}') {
              if (st.isEmpty() || st.peek() != '{') {

                  return false;
              } else {
                  st.pop();
              }

          }

          else if (ch == ']') {
              if (st.isEmpty() || st.peek() != '[') {

                  return false;
              } else {
                  st.pop();
              }

          } else {
              st.push(ch);
          }

      }
      return st.isEmpty();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a string of parentheses: ");
    String s = sc.nextLine();
    

    boolean result =isValid(s);
    
    if (result) {
      System.out.println("The string is valid.");
    } else {
      System.out.println("The string is not valid.");
    }
  }
}
