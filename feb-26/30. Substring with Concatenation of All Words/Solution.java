class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> res = new ArrayList<>();
        if (s == null || words.length == 0) return res;

        int wordLen = words[0].length();
        int totalWords = words.length;

        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        for (int offset = 0; offset < wordLen; offset++) {

            int left = offset;
            int count = 0;
            Map<String, Integer> window = new HashMap<>();

            for (int right = offset; right + wordLen <= s.length(); right += wordLen) {

                String word = s.substring(right, right + wordLen);

                if (map.containsKey(word)) {

                    window.put(word, window.getOrDefault(word, 0) + 1);
                    count++;

                    while (window.get(word) > map.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    if (count == totalWords) {
                        res.add(left);
                    }

                } else {
                    window.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return res;
    }
}