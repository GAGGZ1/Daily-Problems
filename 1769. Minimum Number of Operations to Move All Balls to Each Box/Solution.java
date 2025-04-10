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





//    =========   O(n) approach ==========


class Solution {
    public int[] minOperations(String b) {
        int n = b.length();
        int leftmoves = 0;
        int leftballs = 0;
        int leftarr[] = new int[n];
        for (int i = 0; i < n; i++) {
            leftarr[i] = leftmoves;
            leftballs += b.charAt(i) - '0';
            leftmoves += leftballs;
        }
        int rightmoves = 0;
        int rightballs = 0;
        int rightarr[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            rightarr[i] = rightmoves;
            rightballs += b.charAt(i) - '0';
            rightmoves += rightballs;
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = leftarr[i] + rightarr[i];

        }
        return ans;
    }
}