public static int powerSum(int X, int N) {
    // Write your code here
        return solve(X,N,1);

    }
    public static int solve(int x,int n,int curr){
        int pow=(int)Math.pow(curr,n);
        if(pow>x)return 0;
        if(pow==x){
            return 1;
        }
        
        return solve(x-pow,n,curr+1) + solve(x,n,curr+1);
    }