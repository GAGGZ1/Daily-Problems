import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
    public static boolean findRedundantBrackets(String s) 
    {
        Stack<Character>st=new Stack<>();
        int n=s.length();
        boolean ans=false;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='*' || 
            s.charAt(i)=='/' || s.charAt(i)=='('){
                st.push(s.charAt(i));
            }
            else if(s.charAt(i)==')'){
                if(st.peek()=='('){
                    ans=true;
                }
            
            while(st.peek()=='+' || st.peek()=='-' || st.peek()=='*' || 
            st.peek()=='/'){
                st.pop();
            }
            st.pop(); // remove opening bracket

        }}
        return ans;

    }
}
