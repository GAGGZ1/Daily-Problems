
public class Solution {
	public static int longestLength(String str) {
		// Write your code here
    
    int n=str.length();   if(n<=1)return 0;
    int max=0;
    int[]prefsum=new int[n+1];
    for(int i=1;i<=n;i++){
        prefsum[i]=prefsum[i-1]+str.charAt(i-1)-'0';
    }

    for(int i=2;i<=n;i+=2){
      for(int j=0;j<=n-i;j++){
        int mid =j+ i/2;
        int leftsum=prefsum[mid]-prefsum[j];
        int rightsum=prefsum[j+i]-prefsum[mid];
        if(leftsum==rightsum){
          max=Math.max(max,i);
        }
      }
    }
    return max;
	}

}
