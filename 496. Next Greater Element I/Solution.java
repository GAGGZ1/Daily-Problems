class Solution {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      Stack<Integer> st = new Stack<>();
      HashMap<Integer, Integer> map = new HashMap<>();
      int m = nums2.length;
      for (int i = m - 1; i >= 0; i--) {
          int ele = nums2[i];

          while (!st.isEmpty() && st.peek() < ele) {
              st.pop();
          }
          if (st.isEmpty()) {
              map.put(ele, -1);
          } else {
              map.put(ele, st.peek());
          }
          st.push(ele);
      }
      int n = nums1.length;
      int[] ans = new int[n];
      for (int i = 0; i < n; i++) {
          ans[i] = map.get(nums1[i]);
      }
      return ans;
  }
}