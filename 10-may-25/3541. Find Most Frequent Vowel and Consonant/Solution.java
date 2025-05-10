class Solution {
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int maxFreqSum(String s) {
        HashMap<Character, Integer> mapv = new HashMap<>();
        HashMap<Character, Integer> mapc = new HashMap<>();

        for (char c : s.toCharArray()) {

            if (isVowel(c)) {
                mapv.put(c, mapv.getOrDefault(c, 0) + 1);
            } else {
                mapc.put(c, mapc.getOrDefault(c, 0) + 1);
            }

        }

        int maxv = 0;
        int maxc = 0;

        for (int v : mapv.values()) {
            if (v > maxv) {
                maxv = v;
            }
        }

        for (int v : mapc.values()) {
            if (v > maxc) {
                maxc = v;
            }
        }

        return maxv + maxc;
    }
}
