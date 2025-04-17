import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		 sc.nextLine();
		while(t-->0){
		    int n=sc.nextInt();
		    sc.nextLine();
		    String s=sc.nextLine();
		    int b=0;
		    int g=0;
		    int i=0;
		    int ans=0;
		    while(i<n && b<=(2*g)){
		        if(s.charAt(i)=='B'){
		            b++;
		        }
		        else{
		            g++;
		        }
		        ans++;
		        i++;
		    }
		    System.out.println(ans);
		}

	}
}
