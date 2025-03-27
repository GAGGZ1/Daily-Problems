import java.util.*;
class Solution {
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
      int n = rooms.size();
      Queue<Integer> q = new LinkedList<>();
      boolean[] visited = new boolean[n];
      q.add(0);
      visited[0] = true;
      while (!q.isEmpty()) {
          int curr = q.poll();

          for (int ele : rooms.get(curr)) {
              if (!visited[ele]) {
                  q.add(ele);
                  visited[ele] = true;
              }
          }
      }
      for (int i = 0; i < n; i++) {
          if (visited[i] == false) {
              return false;
          }
      }
      return true;
  }
}