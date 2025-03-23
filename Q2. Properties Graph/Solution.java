
class Solution {
  public static int findConnectedComponents(ArrayList<ArrayList<Integer>> graph, int n) {
      boolean[] visited = new boolean[n];
      int components = 0;

      for (int i = 0; i < n; i++) {
          if (!visited[i]) {
              bfs(graph, i, visited);
              components++;
          }
      }
      return components;
  }

  private static void bfs(ArrayList<ArrayList<Integer>> graph, int start, boolean[] visited) {
      Queue<Integer> queue = new LinkedList<>();
      queue.add(start);
      visited[start] = true;

      while (!queue.isEmpty()) {
          int node = queue.poll();
          for (int neighbor : graph.get(node)) {
              if (!visited[neighbor]) {
                  visited[neighbor] = true;
                  queue.add(neighbor);
              }
          }
      }
  }

  public int numberOfComponents(int[][] arr, int k) {
      int n = arr.length;
      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

      for (int i = 0; i < n; i++) {
          graph.add(new ArrayList<>());
      }

      for (int i = 0; i < n; i++) {
          int ele[] = arr[i];
          for (int j = i + 1; j < n; j++) {
              int[] ele2 = arr[j];
              if (countCommonDistinctElements(ele, ele2) >= k) {
                  graph.get(i).add(j);
                  graph.get(j).add(i);
              }
          }
      }

      return findConnectedComponents(graph, n);
  }

  public static int countCommonDistinctElements(int[] arr1, int[] arr2) {
      HashSet<Integer> set1 = new HashSet<>();
      HashSet<Integer> set2 = new HashSet<>();

      for (int num : arr1) {
          set1.add(num);
      }

      for (int num : arr2) {
          if (set1.contains(num)) {
              set2.add(num);
          }
      }

      return set2.size();
  }

}
