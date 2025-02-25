import java.util.*;
public class Solution {
  static Map<String,Long>dp=new HashMap<>();
  static long solve(String s,int idx,int tight,int cnt){
    if(idx==s.length()) {
      return cnt;
    }
    String key=idx+""+tight+""+cnt;
    if(dp.containsKey(key)) return dp.get(key);
    int limit=(tight==1)?(s.charAt(idx)-'0'):9;
    long ans=0;
    for(int i=0;i<=limit;i++){
      int updatecnt=cnt+(i==3?1:0);
      ans+=solve(s,idx+1,(tight==1 && i==limit)?1:0,updatecnt);

    }
    dp.put(key,ans);
    return ans;
  }
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);

    int l=sc.nextInt();
    int r=sc.nextInt();

    String ri=Integer.toString(r);
    dp.clear();
    long rightans=solve(ri,0,1,0);
    String le=Integer.toString(l-1);
    dp.clear();
    long leftans=solve(le,0,1,0);
    System.out.println(rightans-leftans);
    sc.close();
  }
}
