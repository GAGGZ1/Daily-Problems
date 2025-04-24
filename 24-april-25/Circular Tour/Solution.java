import java.util.* ;
import java.io.*; 
 
public class Solution {
	public static int firstCircularTour(int[] gas, int[] cost, int n) {
		long cal=0;
        long tg=0;
        long tc=0;
        int s=0;
        for(int i=0;i<n;i++){
            tg+=gas[i];
            tc+=cost[i];
            cal+=gas[i]-cost[i];
            if(cal<0){
                cal=0;
                s=i+1;
            }
        }
        if(tg>=tc){
            return s%n;
        }
        return -1;
	}

}
