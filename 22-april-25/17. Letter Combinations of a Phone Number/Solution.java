class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        String[] map = {
                " ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        List<String> ls = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(0, digits, map, sb, ls);
        return ls;
    }

    public void solve(int i, String digits, String[] map, StringBuilder sb, List<String> ls) {
        if (i == digits.length()) {
            ls.add(sb.toString());
            return;
        }
        char d = digits.charAt(i);
        String s = map[d - '0'];
        for (char c : s.toCharArray()) {
            sb.append(c);
            solve(i + 1, digits, map, sb, ls);
            sb.setLength(sb.length() - 1);
        }
    }
}
