class Solution {
  public List<Integer> goodDaysToRobBank(int[] s, int time) {
      int n = s.length;
      int left[] = new int[n];
      int right[] = new int[n];

      for (int i = 1; i < n; i++) {
          if (s[i - 1] >= s[i]) {
              left[i] = left[i - 1] + 1;
          } else {
              left[i] = 0;
          }
      }

      for (int i = n - 2; i >= 0; i--) {
          if (s[i + 1] >= s[i]) {
              right[i] = right[i + 1] + 1;
          } else {
              right[i] = 0;
          }
      }

      ArrayList<Integer> ls = new ArrayList<>();
      for (int i = time; i < n - time; i++) {
          if (left[i] >= time && right[i] >= time) {
              ls.add(i);
          }
      }
      return ls;

  }
}