class Solution {
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
      List<List<Integer>> allPaths = new ArrayList<>();
      List<Integer> currPath = new ArrayList<>();
      solve(graph, 0, currPath, allPaths);
      return allPaths;

  }

  public void solve(int[][] graph, int currNode, List<Integer> currPath, List<List<Integer>> allPaths) {

      currPath.add(currNode);
      if (currNode == graph.length - 1) {
          allPaths.add(new ArrayList<>(currPath));
      } else {
          for (int n : graph[currNode]) {
              solve(graph, n, currPath, allPaths);

          }
      }
      currPath.remove(currPath.size() - 1);

  }
}