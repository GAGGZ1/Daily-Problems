class Solution {
  public int maxContainers(int n, int w, int maxWeight) {
      int ans = 0;
      int sum = 0;

      for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
              if (sum + w <= maxWeight) { 
                  ans++;
                  sum += w;
              // } else {
              //     return ans;
              }
          }
      }

      return ans;
  }
}
