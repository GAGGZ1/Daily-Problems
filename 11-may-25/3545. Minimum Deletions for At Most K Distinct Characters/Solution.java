public class Solution {
  
}
class Solution {
    public int minDeletion(String s, int k) {
        int[] arr = new int[26];
        HashSet<Character> set = new HashSet<>();
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
            map.put(c, map.getOrDefault(c, 0) + 1);
            set.add(c);

        }
        if (set.size() <= k)
            return 0;
        else {
            int ans = 0;
            Arrays.sort(arr);
            int n = arr.length;
            int req = set.size() - k;
            int count = 0;
            List<Integer> freqList = new ArrayList<>(map.values());
            Collections.sort(freqList);

            for (int i = 0; i < req; i++) {
                ans += freqList.get(i);
            }
            return ans;
        }

    }
}