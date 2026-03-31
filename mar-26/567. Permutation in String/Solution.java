class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        HashMap<Character, Integer> maps1 = new HashMap<>();
        HashMap<Character, Integer> maps2 = new HashMap<>();

        for (char c : s1.toCharArray()) {
            maps1.put(c, maps1.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        while (right < s2.length()) {
            // 1. right wale ko add kro
            char c = s2.charAt(right);
            maps2.put(c, maps2.getOrDefault(c, 0) + 1);
            right++;
            // 2. window move kro
            if (right - left > s1.length()) {
                char l = s2.charAt(left);
                maps2.put(l, maps2.get(l) - 1);
                if (maps2.get(l) == 0) {
                    maps2.remove(l);
                }
                left++;
            }

            // 3. if same window len
            if (right - left == s1.length() && maps1.equals(maps2))
                return true;
        }
        return false;
    }
}