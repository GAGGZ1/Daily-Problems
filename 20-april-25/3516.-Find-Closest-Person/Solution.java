class Solution {
  public int findClosest(int x, int y, int z) {
      if(Math.abs(x-z)<Math.abs(y-z)){
          return 1;
          
      }
      else if(Math.abs(x-z)>Math.abs(y-z)){
          return 2;
      }
      return 0;
  }
}

// Time Complexity: O(1)
// Space Complexity: O(1)