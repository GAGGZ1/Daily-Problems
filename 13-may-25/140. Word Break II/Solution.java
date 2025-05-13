class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Set<String> words = new HashSet<>(wordDict);
        solve(0, s.length(), s, words, new StringBuilder(), res);
        return res;
    }
    public void solve(int start, int n, String s,
            Set<String> words, StringBuilder sb, List<String> res) {
        if (start == n) {
            res.add(sb.toString().trim());
            return;
        }
        for (int i = start; i < n; i++) {
            String currWord = s.substring(start, i + 1);
            if (words.contains(currWord)) {

                int len = sb.length();

                sb.append(currWord).append(" ");

                solve(i + 1, n, s, words, sb, res);

                sb.setLength(len);
            }

        }
    }
}