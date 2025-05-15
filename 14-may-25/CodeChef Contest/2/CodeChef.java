import java.util.Scanner;

public class CodeChef {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = 5;
      int arr[]= new int[n];
      for(int i=0; i<n; i++) {
        arr[i] = sc.nextInt();
      }
      int avg=0;
      for(int i=0;i<n;i++){
        avg+=arr[i];
      }
      avg=avg/5;
      if(avg>=7){
        System.out.println(0);
      }
      else{
          int count=0;
          for(int i=0;i<n;i++){
            if(arr[i]<7){
              count++;
            }
            int var=count*10;
            if((var)/5>=7){
              break; 
            }
          }
          System.out.println( var);
      }
      
    
    }
  }
}
