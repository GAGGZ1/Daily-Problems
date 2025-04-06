class Solution {
  public boolean isSorted(ArrayList<Integer> nums) {
      int n = nums.size();
      for (int i = 1; i < n; i++) {
          if (nums.get(i - 1) > nums.get(i)) {
              return false;
          }
      }
      return true;
  }

  public int minimumPairRemoval(int[] num) {
      int count = 0;
      ArrayList<Integer> nums = new ArrayList<>();
      for (int value : num) {
          nums.add(value);
      }

      while (!isSorted(nums)) {
          int n = nums.size();
          int minSum = Integer.MAX_VALUE;
          int u = -1;

          for (int i = 1; i < n; i++) {
              int currSum = nums.get(i - 1) + nums.get(i);
              if (currSum < minSum) {
                  u = i - 1;
                  minSum = currSum;
              }
          }

          if (u == -1)
              break;

          ArrayList<Integer> arr = new ArrayList<>();
          for (int i = 0; i < n; i++) {
              if (i == u) {
                  arr.add(minSum);
                  i++;
              } else {
                  arr.add(nums.get(i));
              }
          }

          nums = arr;
          count++;
      }

      return count;
  }
}
