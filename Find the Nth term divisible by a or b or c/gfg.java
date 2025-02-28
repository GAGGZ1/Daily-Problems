
class GFG
{
  public static int count(int num,int a,int b,int c,int n){
    return ((num / a) + (num / b) + (num / c) 
                - (num / lcm(a, b)) 
                - (num / lcm(b, c)) 
                - (num / lcm(a, c)) 
                + (num / lcm(a, lcm(b, c)))); 
  }
  public static int lcm(int n,int m){
    return (n*m)/(gcd(n,m));
  }
  public static int gcd(int n,int m){
    if(n==0){
      return m;}
    return gcd(m%n,n);
  }
	
	public static int findNthTerm(int a,int b,int c,int n){
      int low=1;
      int high = Math.max(Math.max(a, b), c) * n;

      while(low<high){
        int mid=low+(high-low)/2;
        if(count(mid,a,b,c,n)<n){
          low=mid+1;
        }else{
          high=mid;
        }
      }return low;
    }
 
	public static void main(String[] args) 
	{ 
		int a = 2, b = 3, c = 5, n = 10; 

		System.out.println(findNthTerm(a, b, c, n)); 

	} 
}


