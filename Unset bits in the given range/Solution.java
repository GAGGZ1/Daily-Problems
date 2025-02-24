import java.util.*;

class Solution 
{
	public static void main (String[] args) 
	{
		int n = 42;
		int i = 2, j = 5;
    int a=(-1)<<(j+1);
    // int b=(2^i-1);
    int b=(1<<i)-1;
    int mask=a|b;
    System.out.println(n & mask);
		
	}
}