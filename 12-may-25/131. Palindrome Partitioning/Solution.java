class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        solve(s, new ArrayList<>(), res, 0);
        return res;
    }

    public boolean ispali(String str, int l, int e) {

        while (l < e) {
            if (str.charAt(l++) != str.charAt(e--))
                return false;
        }
        return true;
    }

    public void solve(String s, List<String> curr, List<List<String>> res, int st) {

        if (st >= s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = st; i < s.length(); i++) {
            // String str = s.substring(st, i + 1);
            if (ispali(s, st, i)) {
                curr.add(s.substring(st, i + 1));
                solve(s, curr, res, i + 1);
                curr.remove(curr.size() - 1);
            }

        }
    }
}