class Solution {
  public int countDigits(int num) {
      int count = 0;
      ArrayList<Integer> arr = new ArrayList<>();
      int n = num;
      while (n > 0) {
          int d = n % 10;
          arr.add(d);
          n = n / 10;
      }
      for (int i = 0; i < arr.size(); i++) {
          if (num % arr.get(i) == 0) {
              count++;
          }
      }
      return count;
  }
}