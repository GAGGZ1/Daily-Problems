import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

class Solution {
    public static ArrayList<String> subsequences(String str) {
        // Write your code here
        ArrayList<String>ans=new ArrayList<>();
        solve(str,new StringBuilder(),ans,0);
        return ans;
    }
    public static void  solve(String s,StringBuilder sb,ArrayList<String> ans,int i){

        if(i==s.length()){
            if(sb.length()>0){
                ans.add(sb.toString());
            }
            return;
        }
        sb.append(s.charAt(i));
        solve(s,sb,ans,i+1);
        sb.deleteCharAt(sb.length() - 1);
        solve(s,sb,ans,i+1);


    }
}