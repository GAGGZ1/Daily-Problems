import java.util.Scanner;
class Main {
  public static int minimumDifference(int[] nums) {
      int n = nums.length;
      return solve(nums, Integer.MAX_VALUE, 0, 0, 0, 0, 0, n / 2);
  }

  public static int solve(int[] nums, int res, int i, int s1, int s2, int sum1, int sum2, int n) {
      if (i >= nums.length) {
          int diff = Math.abs(sum1 - sum2);
          if (diff < res) {
              res = diff;

          }
          return res;
      }
      int include = Integer.MAX_VALUE;
      if (s1 < n) {
          include = solve(nums, res, i + 1, s1 + 1, s2, sum1 + nums[i], sum2, n);
      }
      int exclude = Integer.MAX_VALUE;
      if (s2 < n) {
          exclude = solve(nums, res, i + 1, s1, s2 + 1, sum1, sum2 + nums[i], n);
      }
      return Math.min(include, exclude);
  }



  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of elements in the array: ");
    int n = sc.nextInt();
    int[] nums = new int[n];
    System.out.println("Enter the elements of the array: ");
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }
    
    int result = minimumDifference(nums);
    System.out.println("The minimum difference is: " + result);
  }

}