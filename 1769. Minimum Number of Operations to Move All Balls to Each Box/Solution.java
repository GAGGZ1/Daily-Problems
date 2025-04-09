class Solution {
  public int[] minOperations(String b) {
      int n = b.length();
      ArrayList<Integer> ls = new ArrayList<>();
      for (int i = 0; i < n; i++) {
          if (b.charAt(i) == '1') {
              ls.add(i);
          }
      }
      int[] ans = new int[n];
      // 1->2,4,5
      // 1,3,4
      for (int i = 0; i < n; i++) {
          int sum = 0;
          for (int j= 0; j < ls.size(); j++) {
              sum += Math.abs(i - ls.get(j));
          }
          ans[i] = sum;
      }
      return ans;

  }
}