class Solution {
  public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
      int p1 = 0, p2 = 0;
      int n = nums1.length, m = nums2.length;
      ArrayList<ArrayList<Integer>> ls = new ArrayList<>();

      while (p1 < n && p2 < m) {
          if (nums1[p1][0] == nums2[p2][0]) {
              int sum = nums1[p1][1] + nums2[p2][1];
              ArrayList<Integer> ans = new ArrayList<>();
              ans.add(nums1[p1][0]);
              ans.add(sum);
              ls.add(ans);
              p1++;
              p2++;
          } else if (nums1[p1][0] < nums2[p2][0]) {
              ArrayList<Integer> ans = new ArrayList<>();
              ans.add(nums1[p1][0]);
              ans.add(nums1[p1][1]);
              ls.add(ans);
              p1++;
          } else {
              ArrayList<Integer> ans = new ArrayList<>();
              ans.add(nums2[p2][0]);
              ans.add(nums2[p2][1]);
              ls.add(ans);
              p2++;
          }
      }

      while (p1 < n) {
          ArrayList<Integer> ans = new ArrayList<>();
          ans.add(nums1[p1][0]);
          ans.add(nums1[p1][1]);
          ls.add(ans);
          p1++;
      }

      while (p2 < m) {
          ArrayList<Integer> ans = new ArrayList<>();
          ans.add(nums2[p2][0]);
          ans.add(nums2[p2][1]);
          ls.add(ans);
          p2++;
      }

      int rows = ls.size();
      int[][] arr = new int[rows][2];

      for (int i = 0; i < rows; i++) {
          arr[i][0] = ls.get(i).get(0);
          arr[i][1] = ls.get(i).get(1);
      }

      return arr;
  }
}
