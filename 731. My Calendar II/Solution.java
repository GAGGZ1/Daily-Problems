class MyCalendarTwo {
  TreeMap<Integer, Integer> map;

  public MyCalendarTwo() {
      map = new TreeMap<>();
  }

  public boolean book(int st, int et) {
      map.put(st, map.getOrDefault(st, 0) + 1);
      map.put(et, map.getOrDefault(et, 0) - 1);
      int sum = 0;
      boolean flag = false;
      for (int key : map.values()) {
          sum += key;
          if (sum >= 3) {
              map.put(st, map.getOrDefault(st, 0) - 1);
              map.put(et, map.getOrDefault(et, 0) + 1);
              return false;
          }
      }

      return true;
  }
}

/**
* Your MyCalendarTwo object will be instantiated and called as such:
* MyCalendarTwo obj = new MyCalendarTwo();
* boolean param_1 = obj.book(startTime,endTime);
*/