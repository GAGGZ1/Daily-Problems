class Solution {
  public int maxSatisfied(int[] cus, int[] gru, int k) {
      int n = cus.length;

      int sum = 0;
      for (int i = 0; i < n; i++) {
          if (gru[i] == 0)
              sum += cus[i];
      }
      int left = 0;
      int right = 0;
      int special = 0;
      for (int i = 0; i < k; i++) {
          if (gru[i] == 1)
              special += cus[i];
      }

      int temp = special;
      for (int i = k; i < n; i++) {

          if (gru[i] == 1)
              temp += cus[i];
          if (gru[i - k] == 1)
              temp -= cus[i - k];

          special = Math.max(special, temp);

      }
      return special + sum;
  }
}