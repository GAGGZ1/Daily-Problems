class Pair {
  int element;
  int idx;
  int num;

  public Pair(int element, int idx, int num) {
      this.element = element;
      this.idx = idx;
      this.num = num;
  }
}

class Solution {

  public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
      int n = nums1.length;
      Pair[] pairs = new Pair[n];

      for (int i = 0; i < n; i++) {
          pairs[i] = new Pair(nums1[i], i, nums2[i]);
      }
      Arrays.sort(pairs, Comparator.comparingInt(p -> p.element));
      System.out.println("Sorted Elements with Original Indices:");
      for (Pair pair : pairs) {
          System.out.println("Element: " + pair.element + ", Original Index: " + pair.idx);
      }

      long[] result = new long[n];

      PriorityQueue<Integer> pq = new PriorityQueue<>();
      int prev = -1;
      long sum = 0;
      for (int i = 0; i < n; i++) {
          int n1 = pairs[i].element;
          int idx = pairs[i].idx;
          int n2 = pairs[i].num;
          if (i > 0 && n1 == pairs[i - 1].element) {
              result[pairs[i].idx] = result[pairs[i - 1].idx];
          } else {
              result[pairs[i].idx] = sum;
          }
          pq.add(n2);
          sum += n2;
          if (pq.size() > k) {
              sum -= pq.poll();
          }
      }
      return result;

      // for (Pair pair : pairs) {
      // int num = pair.element;
      // int sum = 0;
      // int idx=pair.idx;
      // for (int nums : pq) {

      // sum += nums;
      // }
      // ;
      // if ( iprev < pair.element) {
      // result[pair.idx] = 0;
      // } else {
      // result[pair.idx] = sum;
      // }
      // prev = pair.element;
      // System.out.println("Sum :" + sum);
      // pq.add(nums2[pair.idx]);
      // if (pq.size() > k) {
      // pq.poll();
      // }

      // }
      // return result;

  }
}