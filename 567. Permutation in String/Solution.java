class Solution {
  public boolean checkInclusion(String s1, String s2) {
      String p = new String(s1);
      String s = new String(s2);
      int k = p.length();
      HashMap<Character, Integer> pmap = new HashMap<>();
      HashMap<Character, Integer> smap = new HashMap<>();
      List<Integer> ans = new ArrayList<>();
      int m = p.length();
      int n = s.length();
      for (int i = 0; i < m; i++) {
          pmap.put(p.charAt(i), pmap.getOrDefault(p.charAt(i), 0) + 1);

      }
      int l = 0;
      int r = 0; 
      while (r < n) {
          smap.put(s.charAt(r), smap.getOrDefault(s.charAt(r), 0) + 1);
          if (r - l + 1 > m) {
              smap.put(s.charAt(l), smap.get(s.charAt(l)) - 1);
              if (smap.get(s.charAt(l)) == 0) {
                  smap.remove(s.charAt(l));
              }

              l++;
          }
          if (smap.equals(pmap)) {
              return true;
          }
          r++;
      }
      return false;

  }
}