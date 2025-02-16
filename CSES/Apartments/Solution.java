import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int m = sc.nextInt(); 
        int k = sc.nextInt();  
        
        int arr[] = new int[n];
        int apart[] = new int[m];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            apart[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        Arrays.sort(apart);
        
        int i = 0, j = 0, count = 0;
        
        while (i < n && j < m) {
            if (Math.abs(arr[i] - apart[j]) <= k) { 
               
                count++;
                i++;
                j++;
            } else if (arr[i] < apart[j] - k) {  
              
                i++;
            } else { 
               
                j++;
            }
        }
        
        System.out.println(count);
    }
}
