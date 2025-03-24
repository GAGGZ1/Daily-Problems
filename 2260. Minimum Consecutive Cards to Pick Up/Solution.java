class Solution {
  public int minimumCardPickup(int[] cards) {
      int n = cards.length;
      int l = 0;
      int r = 0;
      int currmin = 0;
      int ans = Integer.MAX_VALUE;
      HashMap<Integer, Integer> map = new HashMap<>();
      int pairCount = 0;

      while (r < n) {
          map.put(cards[r], map.getOrDefault(cards[r], 0) + 1);
          pairCount += map.get(cards[r]) - 1;
          while (pairCount >= 1) {
              ans = Math.min(ans, r - l + 1);
              map.put(cards[l], map.get(cards[l]) - 1);
              pairCount -= map.get(cards[l]);
              l++;
          }
          r++;

      }
      if (ans == Integer.MAX_VALUE) {
          return -1;
      }
      return ans;
  }
}