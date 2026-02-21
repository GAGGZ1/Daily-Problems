
public class Solution {
  public static String reverse(String s){
    if(s.length()<=1)return s;

    return reverse(s.substring(1))+s.charAt(0);
  }
  public static void main(String[] args){
   long start = System.nanoTime();

        System.out.println(reverse("hello"));

        long end = System.nanoTime();

        long timeTaken = end - start;

        System.out.println("Execution time in nanoseconds: " + timeTaken);
        double timeSeconds = timeTaken / 1_000_000_000.0;

System.out.println("Time in seconds: " + timeSeconds);
  }
}
