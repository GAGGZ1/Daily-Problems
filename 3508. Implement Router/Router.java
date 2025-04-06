import java.util.HashSet;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Queue;

class Router {
  int n;
  HashSet<String> visitedSet;
  HashMap<Integer, ArrayList<Integer>> destTotime;
  HashMap<Integer, Integer> destToStIdx;
  Queue<int[]> q;

  public Router(int memoryLimit) {
    n = memoryLimit;
    visitedSet = new HashSet<>();
    destTotime = new HashMap<>();
    destToStIdx = new HashMap<>();
    q = new LinkedList<>();

  }

  public boolean addPacket(int source, int destination, int timestamp) {
    String key = source + "*" + destination + "*" + timestamp;
    if (visitedSet.contains(key))
      return false;

    // if size if full
    if (q.size() == n) {
      int[] remove = q.poll();
      int dest = remove[1];
      String removeKey = remove[0] + "*" + remove[1] + "*" + remove[2];
      visitedSet.remove(removeKey);
      destToStIdx.put(dest, destToStIdx.get(dest) + 1);

    }

    q.add(new int[] { source, destination, timestamp });
    if (!destTotime.containsKey(destination)) {
      destTotime.put(destination,new ArrayList<>());

    }
    destTotime.get(destination).add(timestamp);
    destToStIdx.putIfAbsent(destination, 0);
    visitedSet.add(key);
    return true;

  }

  public int[] forwardPacket() {
    if (q.isEmpty())
      return new int[] {};
    int[] remove = q.poll();
    String removeKey = remove[0] + "*" + remove[1] + "*" + remove[2];
    int dest = remove[1];
    visitedSet.remove(removeKey);
    destToStIdx.put(dest, destToStIdx.get(dest) + 1);
    return remove;

  }

  public int getCount(int destination, int startTime, int endTime) {
    List<Integer> timestamp = destTotime.get(destination);
    if (timestamp == null)
      return 0;
  
    int lowIdx = destToStIdx.getOrDefault(destination, 0);

    int startIdx = lowerBound(timestamp, lowIdx, startTime);
    if (startIdx == -1) {
      return 0;
    }
    int endIdx = upperBound(timestamp, lowIdx, endTime);
    if (endIdx == -1 || endIdx < startIdx) return 0;

    return endIdx - startIdx + 1;

  }

  public int lowerBound(List<Integer> arr, int low, int target) {
    int high = arr.size() - 1;
    int ans = -1;

    while (low <= high) {
      int mid = (high + low) / 2;
      if (arr.get(mid) >= target) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return ans;
  }

  public int upperBound(List<Integer> arr, int low, int target) {
    int high = arr.size() - 1;
    int ans = -1;

    while (low <= high) {
      int mid = (high + low) / 2;
      if (arr.get(mid) <= target) {
        ans = mid;
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return ans;
  }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */