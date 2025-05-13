public static List<Integer> longestCommonSubsequence(List<Integer> a, List<Integer> b) {
    // Write your code here
        int n=a.size();
        int m=b.size();
        int [][]dp=new int [n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a.get(i-1).equals(b.get(j-1))){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        List<Integer>res=new ArrayList<>();
        int i=n;
        int j=m;
        while(i>0 && j>0){
            if(a.get(i-1).equals(b.get(j-1))){
                res.add(a.get(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }
        Collections.reverse(res);
        return res;
        

    }