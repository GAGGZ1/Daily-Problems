class Solution {
  public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
      // Arrays.sort(fruits);
      // Arrays.sort(baskets);
      int count = 0;
      int n = baskets.length;
      HashSet<Integer> set = new HashSet<>();

      for (int i = 0; i < n; i++) {

          for (int j = 0; j < n; j++) {
              if (baskets[j] >= fruits[i]) {
                  baskets[j] = -1;
                  break;
              }
          }

      }
      for (int i = 0; i < n; i++) {
          if (baskets[i] != -1) {
              count++;
          }
      }
      return count;
  }
}
