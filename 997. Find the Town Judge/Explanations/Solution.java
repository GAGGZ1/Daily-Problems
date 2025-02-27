class Solution {
  public int findJudge(int n, int[][] trust) {
      // Array to track trust scores of each person
      int[] people = new int[n + 1];

      // Process the trust relationships
      for (int[] arr : trust) {
          people[arr[0]]--; // Decrease trust score for the person who trusts someone
          people[arr[1]]++; // Increase trust score for the person who is trusted
      }

      // Identify the town judge
      for (int i = 1; i <= n; i++) {
          // The judge must have a trust score of exactly (n - 1)
          // This means they are trusted by everyone except themselves
          if (people[i] == n - 1) {
              return i;
          }
      }

      // If no judge is found, return -1
      return -1;
  }
}
