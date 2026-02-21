class Solution {
    static int sumOfDigits(int n) {
       return help(n,0);
        
    }
    
    static int help(int n,int sum){
    
    if(n==0)return sum;
    
    sum+=n%10;
    return help(n/10,sum);
}
}