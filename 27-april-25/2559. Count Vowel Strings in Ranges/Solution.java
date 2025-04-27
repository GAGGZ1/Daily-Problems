class Solution {
  public boolean isVowel(char ch) {
      return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
  }

  public int[] vowelStrings(String[] words, int[][] queries) {
      int n=words.length;

      int p[]=new int [n+1];
      p[0]=0;
      for(int i=1;i<=n;i++){
          String s=words[i-1];
          char st=s.charAt(0);
          char ed=s.charAt(s.length()-1);
          if(isVowel(st) && isVowel(ed)){
              p[i]=p[i-1]+1;
          }
          else{
              p[i]=p[i-1]+0;
          }
      }
      int ans[]=new int[queries.length];

      int idx=0;
      for(int []q:queries){
          int u=q[0];
          int v=q[1];
          ans[idx++]=p[v+1]-p[u];


      }
      return ans;
  }
}