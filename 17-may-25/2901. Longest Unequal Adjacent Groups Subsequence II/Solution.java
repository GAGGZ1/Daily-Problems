class Solution {
    public boolean hamming(String s, String t) {
        int d = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                d++;
            }
            if (d > 1)
                return false;
        }
        if (d == 1)
            return true;
        return false;
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int parent[] = new int[n];
        int lis[] = new int[n];
        Arrays.fill(lis, 1);
        Arrays.fill(parent, -1);
        int lislen = 1;
        int lisend = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (words[i].length() == words[j].length() &&
                        groups[i] != groups[j] &&
                        hamming(words[i], words[j]) &&
                        lis[i] + 1 > lis[j]) {
                    lis[j] = lis[i] + 1;
                    parent[j] = i;
                    if (lis[j] > lislen) {
                        lisend = j;
                        lislen = lis[j];
                    }
                }
            }

        }

        List<String> res = new ArrayList<>();

        for (int i = lisend; i != -1; i = parent[i]) {
            res.add(words[i]);
        }

        Collections.reverse(res);
        return res;
    }
}