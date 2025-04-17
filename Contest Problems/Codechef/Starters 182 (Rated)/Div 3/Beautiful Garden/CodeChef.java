import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int n=sc.nextInt();
		    int k=sc.nextInt();
		    int d=sc.nextInt();
		    int[]arr=new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=sc.nextInt();
		    }
		    
		    
		    int fin[]=new int[d];
		    if(k==n){
		        System.out.println("0");
		    }
		    else{
		        Arrays.sort(arr);
		        
		        int currcount=0;
		        int last=n-k;
		        for(int i=0;i<last;i++){
		            int first=arr[i];
		            for(int j=0;j<d;j+=first){
		                fin[j]+=1;
		            }
		        }
		        int ans=0;
		        for(int i=0;i<d;i++){
		            ans+=fin[i];
		        }
		        System.out.println(ans);
		    }
		    
		}

	}
}
