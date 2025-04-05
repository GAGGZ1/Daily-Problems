class Solution {
  public static boolean isPrime(int n) {
      if (n <= 1)
          return false; // 0 and 1 are not prime
      if (n == 2 || n == 3)
          return true; // 2 and 3 are prime
      if (n % 2 == 0 || n % 3 == 0)
          return false; // eliminate multiples of 2 and 3

      // Check from 5 to sqrt(n) using 6k ± 1 optimization
      for (int i = 5; i * i <= n; i += 6) {
          if (n % i == 0 || n % (i + 2) == 0)
              return false;
      }
      return true;
  }

  public int[] closestPrimes(int left, int right) {
      ArrayList<Integer> arr = new ArrayList<>();
      for (int i = left; i <= right; i++) {
          if (isPrime(i)) {
              arr.add(i);
          }
      }

      int size = arr.size();
      int[] nums = new int[size];
      for (int i = 0; i < size; i++) {
          nums[i] = arr.get(i);
      }

      int min = Integer.MAX_VALUE;
      int n1 = -1;
      int n2 = -1;
      for (int i = 1; i < size; i++) {
          int diff = nums[i] - nums[i - 1];
          if (diff < min) {
              min = diff;
              n1 = nums[i - 1];
              n2 = nums[i];
          }
      }
      return new int[] { n1, n2 };

  }
}